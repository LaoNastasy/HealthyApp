package com.example.healthyapp.features.person

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_person.view.*

class PersonFragment : BaseFragment<PersonPresenter, PersonView>(), PersonView {

    override fun initPresenter() = DI.component.personPresenter()

    override fun getMvpView() = this

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_person, container, false)
        val roomNumber = arguments?.getLong(PersonFragment::class.simpleName) ?: 0

        view.back.setOnClickListener { presenter.onBackClick() }

        view.person_save.setOnClickListener {
            if (view.person_height.text.isNullOrEmpty()
                || view.person_sit_height.text.isNullOrEmpty()
                || view.person_back_height.text.isNullOrEmpty()
                || view.person_legs_height.text.isNullOrEmpty()
                || view.person_shoulder_height.text.isNullOrEmpty()
                || view.person_shoulder_height.text.isNullOrEmpty()
            )
                return@setOnClickListener

            presenter.onSaveClick(
                height = view.person_height.text.toString(),
                sitHeight = view.person_sit_height.text.toString(),
                backHeight = view.person_back_height.text.toString(),
                legsHeight = view.person_legs_height.text.toString(),
                shoulderHeight = view.person_shoulder_height.text.toString(),
                roomNumber = roomNumber
            )
        }


        return view
    }

    override fun goBack() {
        Navigation.findNavController(view ?: return).popBackStack()
    }

    override fun showWorkplace() {
        Navigation.findNavController(view ?: return).navigate(R.id.workplaceBottomFragment)
    }

    override fun showErrorAlert(message: Int) {
        AlertDialog.Builder(context ?: return)
            .setMessage(message)
            .setPositiveButton(R.string.ok) { dialog, which -> dialog.dismiss() }
            .show()
    }

}