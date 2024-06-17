package com.carrinhoorganizado.view.uistate

sealed class UiStateRecoverPassword{
    data object RecoverPassword : UiStateRecoverPassword()
    data object ErrorRecoverPassword : UiStateRecoverPassword()
}
