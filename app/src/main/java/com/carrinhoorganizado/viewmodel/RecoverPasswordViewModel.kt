package com.carrinhoorganizado.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carrinhoorganizado.extension.isInvalidEmail
import com.carrinhoorganizado.repository.ShoppingCartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecoverPasswordViewModel @Inject constructor(private val repository: ShoppingCartRepository) :
    ViewModel()  {
    private val TAG = "RecoverPasswordViewModel"
    val recoverPassword = MutableLiveData<Boolean>()
    val errorLogin = MutableLiveData<Boolean>()

    init {
        recoverPassword.value = false
        errorLogin.value = false
    }

    fun recoverPasswordAuthenticationFirebase(email: String) {
        Log.i(TAG,"Por favor tudo pronto para recuperar senha: $email")
    }

    fun verifyField(email: String) {
        when {
            email.isInvalidEmail() -> errorLogin.value = true
            else -> {
                errorLogin.value = false
                recoverPassword.value = true
            }
        }
    }
}