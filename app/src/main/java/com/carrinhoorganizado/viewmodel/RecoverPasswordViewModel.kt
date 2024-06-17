package com.carrinhoorganizado.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carrinhoorganizado.extension.isInvalidEmail
import com.carrinhoorganizado.repository.ShoppingCartRepository
import com.carrinhoorganizado.view.uistate.UiStateRecoverPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecoverPasswordViewModel @Inject constructor(private val repository: ShoppingCartRepository) :
    ViewModel()  {
    private val TAG = "RecoverPasswordViewModel"
    val uiState = MutableLiveData<UiStateRecoverPassword?>()

    fun recoverPasswordAuthenticationFirebase(email: String) {
        Log.i(TAG,"Por favor tudo pronto para recuperar senha: $email")
    }

    fun verifyField(email: String) {
       uiState.value = when {
            email.isInvalidEmail() -> UiStateRecoverPassword.ErrorRecoverPassword
            else -> {
                UiStateRecoverPassword.RecoverPassword
            }
        }
    }
}