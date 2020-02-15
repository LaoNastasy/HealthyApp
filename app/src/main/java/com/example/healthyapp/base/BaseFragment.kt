package com.example.healthyapp.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.healthyapp.main.MainActivity
import com.example.healthyapp.navigation.Navigator

abstract class BaseFragment<P : BasePresenter<V>, V : BaseView> : Fragment() {

    lateinit var presenter: P
    protected lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = initPresenter()
        navigator = (activity as MainActivity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(getMvpView())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    protected fun showError(message: String?) {
        if (!message.isNullOrBlank())
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
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