package com.carrinhoorganizado.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carrinhoorganizado.extension.isInvalidEmail
import com.carrinhoorganizado.repository.ShoppingCartRepository
import com.carrinhoorganizado.view.uistate.UiStateLogin
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: ShoppingCartRepository) :
    ViewModel() {
    private val TAG = "LoginViewModel"
    val uiState = MutableLiveData<UiStateLogin?>()

    fun clearUiState(){
        uiState.value = null
    }


    fun startLoginAuthenticationFirebase() {
        Log.i(TAG,"Por favor tudo ok para logar")
    }

    fun verifyField(email: String, password: String) {
        uiState.value = when {
            email.isInvalidEmail() ->  UiStateLogin.ErrorLogin
            password.isBlank() -> UiStateLogin.ErrorLogin
            else -> {
                UiStateLogin.StartLogin
            }
        }
    }
}