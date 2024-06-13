package com.carrinhoorganizado.extension

import android.util.Patterns

fun String?.isInvalidEmail() : Boolean {
    return this.isNullOrBlank() || Patterns.EMAIL_ADDRESS.matcher(this).matches().not()
}