package com.example.healthyapp

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import org.junit.Test
import org.mockito.Mockito


class BasePresenterTest {

    private val view = Mockito.mock(BaseView::class.java)
    private val basePresenter = BasePresenter<BaseView>()


    @Test
    fun `attach view`() {
        basePresenter.attachView(view)
        assert(basePresenter.view == view)
        assert(basePresenter.isViewAttached())
    }

    @Test
    fun `detach view`(){
        basePresenter.detachView()
        assert(basePresenter.view == null)
        assert(!basePresenter.isViewAttached())
    }
}