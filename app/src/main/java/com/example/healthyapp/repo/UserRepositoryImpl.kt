package com.example.healthyapp.repo

import android.content.Context
import com.example.healthyapp.PreferenceUtils
import com.example.healthyapp.db.Database
import com.example.healthyapp.db.model.entity.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


open class UserRepositoryImpl @Inject constructor(val database: Database, val context: Context) :
    UserRepository {

    private val prefs = PreferenceUtils(context)

    override fun getUserByLogin(
        login: String,
        onSuccess: (user: User?) -> Unit,
        onError: () -> Unit
    ) {
        try {
            GlobalScope.launch {
               val user = database.getUserDao().getUserByLogin(login)
                onSuccess.invoke(user)
            }
        }catch (ex:Exception){
            onError.invoke()
        }

    }

    override fun isUserSignedIn(): Boolean {
        return prefs.getString(LOGIN) != ""
    }

    override fun signIn(login: String, onSuccess: () -> Unit, onError: () -> Unit) {
        try {
            prefs.saveString(login, LOGIN)
            onSuccess.invoke()
        } catch (ex: Exception) {
            onError.invoke()
        }
    }

    override fun logout(onSuccess: () -> Unit, onError: () -> Unit) {
        try {
            prefs.saveString("", LOGIN)
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
        try {
            GlobalScope.launch {
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
                onSuccess.invoke()
            }

        } catch (ex: Exception) {
            onError.invoke()
        }
    }

    companion object {
        private const val LOGIN = "Login"
    }
}