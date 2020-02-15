package com.example.healthyapp.repo.implementations

import android.content.Context
import com.example.healthyapp.PreferenceUtils
import com.example.healthyapp.db.Database
import com.example.healthyapp.db.model.entity.User
import com.example.healthyapp.repo.UserRepository
import kotlinx.coroutines.*
import java.lang.Exception
import javax.inject.Inject


open class UserRepositoryImpl @Inject constructor(val database: Database, val context: Context) :
    UserRepository {

    private val prefs = PreferenceUtils(context)

    override fun getUserByLogin(
        login: String,
        onSuccess: (user: User) -> Unit,
        onError: () -> Unit
    ) {

        CoroutineScope(Dispatchers.IO).launch {
            val user = database.getUserDao().getUserByLogin(login)
            withContext(Dispatchers.Main) {
                if (user == null) onError.invoke()
                else onSuccess.invoke(user)
            }
        }


    }

    override fun isUserSignedIn(): Boolean {
        return prefs.getString(LOGIN) != ""
    }

    override fun signIn(login: String, onSuccess: () -> Unit, onError: () -> Unit) {
        try {
            prefs.saveString(
                login,
                LOGIN
            )
            onSuccess.invoke()
        } catch (ex: Exception) {
            onError.invoke()
        }
    }

    override fun logout(onSuccess: () -> Unit, onError: () -> Unit) {
        try {
            prefs.saveString(
                "",
                LOGIN
            )
            onSuccess.invoke()
        } catch (ex: Exception) {
            onError.invoke()
        }
    }

    override fun signUp(
        login: String,
        password: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {

        CoroutineScope(Dispatchers.IO).launch {
            database.getUserDao().addUser(
                User(
                    id = 0,
                    login = login,
                    password = password,
                    role = "developer",
                    firstName = "Ivan",
                    secondName = "Petrov"
                )
            )
            withContext(Dispatchers.Main) { onSuccess.invoke() }
        }

    }

    companion object {
        private const val LOGIN = "Login"
    }
}