package com.carrinhoorganizado.view.uistate

sealed class UiStateCreateAccount {
    data object CreateAccount : UiStateCreateAccount()
    data object ErrorCreateAccount : UiStateCreateAccount()
}
