package com.example.healthyapp.di

import android.content.Context
import androidx.room.Room
import com.example.healthyapp.UserRepository
import com.example.healthyapp.UserRepositoryImpl
import com.example.healthyapp.db.Database
import dagger.Module
import dagger.Provides

@Module
class AppModule(var context: Context) {

    @Provides
    fun provideDatabase(context: Context): Database = Room.databaseBuilder(
        context,
        Database::class.java, "database"
    ).build()

    @Provides
    fun context(): Context {
        return context.applicationContext
    }

    @Provides
    fun userRepo(database: Database): UserRepository = UserRepositoryImpl(database)

}