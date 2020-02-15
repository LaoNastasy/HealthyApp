package com.example.healthyapp.features.klimat

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView

interface ClimateView:BaseView{
    fun goBack()
}

class ClimatePresenter :BasePresenter<ClimateView>() {

    fun onBackClick() = view?.goBack()
}