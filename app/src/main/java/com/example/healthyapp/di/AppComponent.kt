package com.example.healthyapp.di

import com.example.healthyapp.features.auth.AuthenticationFragment
import com.example.healthyapp.features.auth.AuthenticationPresenter
import com.example.healthyapp.features.klimat.ClimateFragment
import com.example.healthyapp.features.klimat.ClimatePresenter
import com.example.healthyapp.features.main_screen.MainFragment
import com.example.healthyapp.features.main_screen.MainScreenPresenter
import com.example.healthyapp.features.person.PersonFragment
import com.example.healthyapp.features.person.PersonPresenter
import com.example.healthyapp.features.person.WorkplaceBottomFragment
import com.example.healthyapp.main.MainActivity
import com.example.healthyapp.main.MainPresenter
import com.example.healthyapp.features.registration.RegistrationFragment
import com.example.healthyapp.features.statistic.StatisticFragment
import com.example.healthyapp.features.statistic.StatisticPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun injectMainActivity(mainActivity: MainActivity)

    fun injectAuthFragment(authFragment: AuthenticationFragment)

    fun injectRegistrationFragment(registrationFragment: RegistrationFragment)

    fun injectMainScreenFragment(fragment: MainFragment)

    fun injectStatisticFragment(fragment: StatisticFragment)

    fun injectClimateFragment(fragment: ClimateFragment)

    fun injectPersonFragment(fragment: PersonFragment)

    fun injectWorkplaceFragment(fragment: WorkplaceBottomFragment)

}