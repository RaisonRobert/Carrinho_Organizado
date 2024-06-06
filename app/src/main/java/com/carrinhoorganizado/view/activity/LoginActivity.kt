package com.carrinhoorganizado.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.carrinhoorganizado.R
import com.carrinhoorganizado.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityLoginBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        configToolbar()
    }

    private fun configToolbar() {
        setSupportActionBar(mBinding.toolbarLogin)
        val navController = mBinding.navHostActivityLogin.getFragment<NavHostFragment>().navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navController.addOnDestinationChangedListener{ _,destination, _ ->
            when(destination.id){
                R.id.login -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    mBinding.toolbarLogin.navigationIcon = null
                }
                else ->{
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                    mBinding.toolbarLogin.setNavigationIcon(R.drawable.ic_arrow_back)
                    mBinding.toolbarLogin.setNavigationOnClickListener { navController.popBackStack() }
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = mBinding.navHostActivityLogin
        return navController.findNavController().navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}