package com.carrinhoorganizado.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.carrinhoorganizado.databinding.FragmentRecoverPasswordBinding
import com.carrinhoorganizado.viewmodel.RecoverPasswordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecoverPasswordFragment : Fragment() {
    private var _binding: FragmentRecoverPasswordBinding? = null
    private val mBinding get() = _binding!!
    private val mViewModel: RecoverPasswordViewModel by viewModels ()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoverPasswordBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupOnClick()
        observeUIState()
    }
    private fun observeUIState() {
        mViewModel.recoverPassword.observe(viewLifecycleOwner) { createAccountLogin ->
            if (createAccountLogin) {
                clearErrorFields()
                val email = mBinding.fieldLogin.text.toString()
                mViewModel.recoverPasswordAuthenticationFirebase(email)
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
    }

    private fun clearErrorFields() {
        mBinding.layoutLogin.error = null
    }

    private fun setupOnClick() {
        mBinding.btnRecoverPassword.setOnClickListener {
            val email = mBinding.fieldLogin.text.toString()
            mViewModel.verifyField(email)
        }
    }

}