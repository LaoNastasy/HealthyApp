package com.example.healthyapp.features.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseBottomFragment
import javax.inject.Inject

class WorkplaceBottomFragment : BaseBottomFragment<PersonPresenter, PersonView>(), PersonView {

    @Inject
    private lateinit var personPresenter: PersonPresenter

    override fun initPresenter(): PersonPresenter = personPresenter

    override fun getMvpView() = this

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_fragment_new_workplace, container, false)

        return view
    }

    override fun goBack() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}