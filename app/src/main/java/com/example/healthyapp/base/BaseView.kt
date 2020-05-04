package com.example.healthyapp.base

import android.widget.Toast
import com.example.healthyapp.R
import com.example.healthyapp.di.DI

interface BaseView {
    fun showError(res: Int = R.string.common_error) {
        Toast.makeText(DI.component.context(), res, Toast.LENGTH_SHORT).show()
    }
}