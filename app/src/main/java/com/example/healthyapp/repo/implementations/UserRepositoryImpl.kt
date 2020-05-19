package com.example.healthyapp.repo.implementations

import android.content.Context
import android.util.Log
import com.example.healthyapp.PreferenceUtils
import com.example.healthyapp.R
import com.example.healthyapp.db.model.entity.User
import com.example.healthyapp.repo.UserRepository
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject


open class UserRepositoryImpl @Inject constructor(val db: FirebaseFirestore, val context: Context) :
    UserRepository {

    private val TAG = UserRepositoryImpl::class.simpleName
    private val prefs = PreferenceUtils(context)

    override fun getUserByLogin(
        login: String,
        onSuccess: (user: User) -> Unit,
        onError: (Int) -> Unit
    ) {

        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                val document = result.find { it.data["login"] == login }
                if (document == null)
                    onError.invoke(R.string.auth_no_login)
                else {
                    onSuccess(
                        User(
                            id = document.id,
                            login = document.data["login"] as String? ?: "",
                            password = document.data["password"] as String? ?: "",
                            firstName = document.data["firstName"] as String? ?: "",
                            secondName = document.data["secondName"] as String? ?: ""
                        )
                    )
                    return@addOnSuccessListener
                }
            }
            .addOnFailureListener { exception ->
                onError.invoke(R.string.common_error)
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

        val user = hashMapOf(
            "login" to login,
            "password" to password
        )

        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                onSuccess.invoke()
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
                onError.invoke()
            }

    }

    companion object {
        private const val LOGIN = "Login"
    }
}