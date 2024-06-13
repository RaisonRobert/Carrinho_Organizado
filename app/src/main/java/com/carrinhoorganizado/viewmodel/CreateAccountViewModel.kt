package com.carrinhoorganizado.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carrinhoorganizado.extension.isInvalidEmail
import com.carrinhoorganizado.repository.ShoppingCartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(private val repository: ShoppingCartRepository) :
    ViewModel()  {
    private val TAG = "CreateAccountViewModel"
    val createAccountLogin = MutableLiveData<Boolean>()
    val errorLogin = MutableLiveData<Boolean>()

    init {
        createAccountLogin.value = false
        errorLogin.value = false
    }

    fun createAccountAuthenticationFirebase(email: String, password: String) {
        Log.i(TAG,"Por favor tudo pronto para criar conta: $email, $password")
    }

    fun verifyField(email: String, password: String) {
        when {
            email.isInvalidEmail() -> errorLogin.value = true
            password.isBlank() -> errorLogin.value = true
            else -> {
                errorLogin.value = false
                createAccountLogin.value = true
            }
        }
    }
}