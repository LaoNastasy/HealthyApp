package com.example.healthyapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<P : BasePresenter<V>, V : BaseView> : AppCompatActivity() {

    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = initPresenter()
        presenter.attachView(getMvpView())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    abstract fun initPresenter(): P

    abstract fun getMvpView(): V
}