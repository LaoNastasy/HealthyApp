package com.example.healthyapp.features.person

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView

interface PersonView:BaseView{
    fun goBack()
}

class PersonPresenter:BasePresenter<PersonView>() {

    fun onBackClick(){
        view?.goBack()
    }
}