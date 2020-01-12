package com.example.healthyapp

import com.example.healthyapp.features.auth.AuthenticationPresenter
import com.example.healthyapp.features.auth.AuthenticationView
import com.example.healthyapp.db.model.entity.User
import com.example.healthyapp.repo.UserRepository
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.times


class AuthTest {


    private val userRepository = Mockito.mock(UserRepository::class.java)
    private val view = Mockito.mock(AuthenticationView::class.java)
    private val presenter = AuthenticationPresenter(userRepository)
    private val user = User(1, "login", "password", "employee", "Alexandr", "Popov")

    @Test
    fun `auth no user`() {
        presenter.view = view
        presenter.login("", "")
        Mockito.verify(view, times(0)).goToMainScreen()
        Mockito.verify(view).showError()

    }

    @Test
    fun `auth right user`() {
        presenter.view = view
        presenter.login("login", "password")
        Mockito.verify(view).goToMainScreen()
        Mockito.verify(view, times(0)).showError()
    }

    @Test
    fun `auth not right user`() {
        presenter.view = view
        (userRepository.getUserByLogin(
            "login",
            onSuccess = { view.goToMainScreen() },
            onError = { view.showError() }))
        presenter.login("login", "")
        Mockito.verify(view, times(0)).goToMainScreen()
        Mockito.verify(view).showError()
    }
}