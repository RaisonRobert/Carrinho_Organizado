package com.carrinhoorganizado.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carrinhoorganizado.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}