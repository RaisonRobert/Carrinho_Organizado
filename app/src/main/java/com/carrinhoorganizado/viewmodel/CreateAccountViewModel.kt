package com.carrinhoorganizado.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carrinhoorganizado.extension.isInvalidEmail
import com.carrinhoorganizado.repository.ShoppingCartRepository
import com.carrinhoorganizado.view.uistate.UiStateCreateAccount
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(private val repository: ShoppingCartRepository) :
    ViewModel() {
    private val TAG = "CreateAccountViewModel"
    val uiState = MutableLiveData<UiStateCreateAccount?>()
    fun clearUiState() {
        uiState.value = null
    }

    fun createAccountAuthenticationFirebase(email: String, password: String) {
        Log.i(TAG, "Por favor tudo pronto para criar conta: $email, $password")
    }

    fun verifyField(email: String, password: String) {
        uiState.value = when {
            email.isInvalidEmail() -> UiStateCreateAccount.ErrorCreateAccount
            password.isBlank() -> UiStateCreateAccount.ErrorCreateAccount
            else -> {
                UiStateCreateAccount.CreateAccount
            }
        }
    }
}