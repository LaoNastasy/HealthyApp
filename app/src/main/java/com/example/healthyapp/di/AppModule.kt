package com.example.healthyapp.di

import android.content.Context
import androidx.room.Room
import com.example.healthyapp.repo.UserRepository
import com.example.healthyapp.repo.implementations.UserRepositoryImpl
import com.example.healthyapp.features.auth.AuthenticationPresenter
import com.example.healthyapp.db.Database
import com.example.healthyapp.features.klimat.ClimatePresenter
import com.example.healthyapp.features.main_screen.MainScreenPresenter
import com.example.healthyapp.features.person.PersonPresenter
import com.example.healthyapp.features.person.WorkplacePresenter
import com.example.healthyapp.features.roomEdit.RoomEditPresenter
import com.example.healthyapp.features.statistic.StatisticPresenter
import com.example.healthyapp.main.MainPresenter
import com.example.healthyapp.repo.LogicRepo
import com.example.healthyapp.repo.implementations.LogicRepoImpl
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

    @Singleton
    @Provides
    fun userRepo(database: Database, context: Context): UserRepository =
        UserRepositoryImpl(
            database,
            context
        )

    @Singleton
    @Provides
    fun logicRepo(database: Database): LogicRepo = LogicRepoImpl(database)

    @Provides
    fun mainPresenter(userRepository: UserRepository): MainPresenter = MainPresenter(userRepository)

    @Provides
    fun authPresenter(userRepository: UserRepository): AuthenticationPresenter =
        AuthenticationPresenter(userRepository)

    @Provides
    fun mainScreenPresenter(userRepository: UserRepository): MainScreenPresenter =
        MainScreenPresenter(userRepository)

    @Provides
    fun statisticPresenter(): StatisticPresenter = StatisticPresenter()

    @Provides
    fun personPresenter(logicRepo: LogicRepo): PersonPresenter = PersonPresenter(logicRepo)

    @Provides
    fun climatePresenter(): ClimatePresenter = ClimatePresenter()

    @Provides
    fun workplacePresenter(logicRepo: LogicRepo): WorkplacePresenter = WorkplacePresenter(logicRepo)

    @Provides
    fun roomEditPresenter(logicRepo: LogicRepo): RoomEditPresenter = RoomEditPresenter(logicRepo)
}