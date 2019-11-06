package com.example.healthyapp.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment<P : BasePresenter<V>, V : BaseView> : Fragment() {

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