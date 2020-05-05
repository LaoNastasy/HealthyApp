package com.example.healthyapp.di

import android.content.Context
import com.example.healthyapp.repo.UserRepository
import com.example.healthyapp.repo.implementations.UserRepositoryImpl
import com.example.healthyapp.features.auth.AuthenticationPresenter
import com.example.healthyapp.features.main_screen.MainScreenPresenter
import com.example.healthyapp.features.person.PersonPresenter
import com.example.healthyapp.features.person.RoomNumberPresenter
import com.example.healthyapp.features.person.WorkplacePresenter
import com.example.healthyapp.features.registration.RegistrationPresenter
import com.example.healthyapp.features.roomEdit.RoomEditPresenter
import com.example.healthyapp.features.statistic.StatisticPresenter
import com.example.healthyapp.main.MainPresenter
import com.example.healthyapp.repo.WorkplaceRepo
import com.example.healthyapp.repo.implementations.WorkplaceRepoImpl
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideDatabase(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun context(): Context {
        return context.applicationContext
    }

    @Singleton
    @Provides
    fun userRepo(database: FirebaseFirestore, context: Context): UserRepository =
        UserRepositoryImpl(
            database,
            context
        )

    @Singleton
    @Provides
    fun logicRepo(database: FirebaseFirestore): WorkplaceRepo = WorkplaceRepoImpl(database)

    @Provides
    fun mainPresenter(userRepository: UserRepository): MainPresenter = MainPresenter(userRepository)

    @Provides
    fun authPresenter(userRepository: UserRepository): AuthenticationPresenter =
        AuthenticationPresenter(userRepository)

    @Provides
    fun registrationPresenter(userRepo: UserRepository): RegistrationPresenter =
        RegistrationPresenter(userRepo)

    @Provides
    fun mainScreenPresenter(userRepository: UserRepository): MainScreenPresenter =
        MainScreenPresenter(userRepository)

    @Provides
    fun statisticPresenter(): StatisticPresenter = StatisticPresenter()

    @Provides
    fun personPresenter(workplaceRepo: WorkplaceRepo): PersonPresenter =
        PersonPresenter(workplaceRepo)

    @Provides
    fun workplacePresenter(workplaceRepo: WorkplaceRepo): WorkplacePresenter =
        WorkplacePresenter(workplaceRepo)

    @Provides
    fun roomEditPresenter(workplaceRepo: WorkplaceRepo): RoomEditPresenter =
        RoomEditPresenter(workplaceRepo)

    @Provides
    fun roomNumberPresenter(workplaceRepo: WorkplaceRepo): RoomNumberPresenter = RoomNumberPresenter(workplaceRepo)
}