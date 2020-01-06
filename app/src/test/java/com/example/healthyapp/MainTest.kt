package com.example.healthyapp

import com.example.healthyapp.main.MainPresenter
import com.example.healthyapp.main.MainView
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class MainTest {

    private val userRepository = Mockito.mock(UserRepository::class.java)
    private val view = Mockito.mock(MainView::class.java)
    private val presenter = MainPresenter(userRepository)

    @Test
    fun `not signed in`(){
        presenter.view = view
        presenter.checkAuth()
        Mockito.verify(view).goToAuthFragment()
    }

    @Test
    fun `signed in`(){
        presenter.view = view
        `when`(userRepository.isUserSignedIn()).thenReturn(true)
        presenter.checkAuth()
        Mockito.verify(view).goToBaseRoomEditFragment()
    }
}