package com.carrinhoorganizado.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.carrinhoorganizado.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}