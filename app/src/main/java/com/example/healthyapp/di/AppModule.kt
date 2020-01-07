package com.example.healthyapp.di

import android.content.Context
import androidx.room.Room
import com.example.healthyapp.repo.UserRepository
import com.example.healthyapp.repo.UserRepositoryImpl
import com.example.healthyapp.features.auth.AuthenticationPresenter
import com.example.healthyapp.db.Database
import com.example.healthyapp.features.main_screen.MainScreenPresenter
import com.example.healthyapp.features.statistic.StatisticPresenter
import com.example.healthyapp.main.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideDatabase(): Database = Room.databaseBuilder(
        context,
        Database::class.java, "database"
    ).build()

    @Provides
    fun context(): Context {
        return context.applicationContext
    }

    @Provides
    fun userRepo(database: Database): UserRepository =
        UserRepositoryImpl(database)

    @Provides
    fun mainPresenter(userRepository: UserRepository): MainPresenter = MainPresenter(userRepository)

    @Provides
    fun authPresenter(userRepository: UserRepository): AuthenticationPresenter =
        AuthenticationPresenter(userRepository)

    @Provides
    fun mainScreenPresenter():MainScreenPresenter = MainScreenPresenter()

    @Provides
    fun statisticPresenter():StatisticPresenter = StatisticPresenter()
}