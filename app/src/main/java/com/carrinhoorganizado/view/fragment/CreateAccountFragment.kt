package com.carrinhoorganizado.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.carrinhoorganizado.databinding.FragmentCreateAcountBinding
import com.carrinhoorganizado.viewmodel.CreateAccountViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateAccountFragment : Fragment() {
    private var _binding: FragmentCreateAcountBinding? = null
    private val mBinding get() = _binding!!
    private val mViewModel: CreateAccountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateAcountBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupOnClick()
        observeUIState()
    }
    private fun observeUIState() {
        mViewModel.createAccountLogin.observe(viewLifecycleOwner) { createAccountLogin ->
            if (createAccountLogin) {
                clearErrorFields()
                val email = mBinding.fieldLogin.text.toString()
                val password = mBinding.fieldPassword.text.toString()
                mViewModel.createAccountAuthenticationFirebase(email, password)
            }
        }
        mViewModel.errorLogin.observe(viewLifecycleOwner) { errorLogin ->
            if (errorLogin) {
                errorFieldLogin("Error digite novamente seu login")
            }
        }
    }

    private fun errorFieldLogin(msg: String) {
        mBinding.layoutLogin.error = msg
        mBinding.layoutPassword.error = msg
    }

    private fun clearErrorFields() {
        mBinding.layoutLogin.error = null
        mBinding.layoutPassword.error = null
    }

    private fun setupOnClick() {
        mBinding.btnCreateAccount.setOnClickListener {
            val email = mBinding.fieldLogin.text.toString()
            val password = mBinding.fieldPassword.text.toString()
            mViewModel.verifyField(email, password)
        }
    }
}