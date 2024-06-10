package com.carrinhoorganizado.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carrinhoorganizado.repository.ShoppingCartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: ShoppingCartRepository) :
    ViewModel() {
    private val TAG = "LoginViewModel"
    val startLogin = MutableLiveData<Boolean>()
    val errorLogin = MutableLiveData<Boolean>()

    init {
        startLogin.value = false
        errorLogin.value = false
    }

    fun startLoginAuthenticationFirebase() {
        Log.i(TAG,"Por favor tudo ok para logar")
    }

    fun verifyFieldLogin(email: String, password: String) {
        when {
            email.isBlank() -> errorLogin.value = true
            password.isBlank() -> errorLogin.value = true
            else -> {
                errorLogin.value = false
                startLogin.value = true
            }
        }
    }
}