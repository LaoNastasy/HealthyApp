package com.example.healthyapp.features.newWorkplace.addPerson

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_person.*
import kotlinx.android.synthetic.main.fragment_person.view.*

class PersonFragment : BaseFragment<PersonPresenter, PersonView>(R.layout.fragment_person),
    PersonView {

    override fun initPresenter() = DI.component.personPresenter()

    override fun getMvpView() = this

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val roomNumber = arguments?.getString("placementId") ?: ""

        back.setOnClickListener { presenter.onBackClick() }

        person_save.setOnClickListener {
            if (view.person_height.text.isNullOrEmpty()
                || person_sit_height.text.isNullOrEmpty()
                || person_back_height.text.isNullOrEmpty()
                || person_legs_height.text.isNullOrEmpty()
                || person_shoulder_height.text.isNullOrEmpty()
                || person_shoulder_height.text.isNullOrEmpty()
            )
                return@setOnClickListener

            presenter.onSaveClick(
                name = person_name.text.toString(),
                height = person_height.text.toString(),
                sitHeight = person_sit_height.text.toString(),
                backHeight = person_back_height.text.toString(),
                legsHeight = person_legs_height.text.toString(),
                shoulderHeight = person_shoulder_height.text.toString(),
                placementId = roomNumber
            )
        }


    }

    override fun goBack() {
        findNavController().popBackStack()
    }

    override fun showWorkplace() {
        val action =
            PersonFragmentDirections.actionPersonFragmentToWorkplaceFragment()
        findNavController().navigate(action)
    }

    override fun showErrorAlert(message: Int) {
        AlertDialog.Builder(context ?: return)
            .setMessage(message)
            .setPositiveButton(R.string.ok) { dialog, _ -> dialog.dismiss() }
            .show()
    }

}