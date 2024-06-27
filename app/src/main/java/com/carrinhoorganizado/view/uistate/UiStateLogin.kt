package com.carrinhoorganizado.view.uistate

sealed class UiStateLogin {
    data object StartLogin : UiStateLogin()
    data object ErrorLogin : UiStateLogin()
}
