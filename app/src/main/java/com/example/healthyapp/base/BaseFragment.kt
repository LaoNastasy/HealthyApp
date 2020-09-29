package com.example.healthyapp.base

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.healthyapp.R

abstract class BaseFragment<P : BasePresenter<V>, V : BaseView>(@LayoutRes layout: Int) :
    Fragment(layout), BaseView {

    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = initPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(getMvpView())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun showError(res: Int) {
        val message = getString(res)
        if (!message.isBlank()) {
            val inflater = layoutInflater
            val container: ViewGroup? = activity?.findViewById(R.id.custom_toast_container)
            val layout: ViewGroup = inflater.inflate(R.layout.custom_toast, container) as ViewGroup
            val text: TextView = layout.findViewById(R.id.custom_toast_text)
            text.text = message
            with(Toast(requireContext())) {
                setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }

    }

    /***
     * должен вернуть сконфигурированный презентер, тут можно передать в презентер все зависимости, если они передаются
     * в конструкторе
     */
    abstract fun initPresenter(): P

    /***
     * должен вернуть вьюху для аттача к презентеру, обычная реализация вернуть this
     */
    abstract fun getMvpView(): V

}