package com.carrinhoorganizado.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.carrinhoorganizado.R
import com.carrinhoorganizado.databinding.FragmentLoginBinding
import com.carrinhoorganizado.view.uistate.UiStateLogin
import com.carrinhoorganizado.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val mBinding get() = _binding!!
    private val mViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupOnClick()
        observeUIState()
    }

    private fun observeUIState() {
        mViewModel.uiState.observe(viewLifecycleOwner) { state ->
            state?.also {
                updateUI(state)
            }
        }
    }

    private fun updateUI(state: UiStateLogin) {
        when (state) {
            is UiStateLogin.StartLogin -> {
                clearErrorFields()
                mViewModel.startLoginAuthenticationFirebase()
            }

            is UiStateLogin.ErrorLogin -> {
                errorFieldLogin("Error digite novamente seu login")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mViewModel.clearUiState()
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
        mBinding.btnLogin.setOnClickListener {
            val email = mBinding.fieldLogin.text.toString()
            val password = mBinding.fieldPassword.text.toString()
            mViewModel.verifyField(email, password)
        }
        mBinding.txtCreateAcount.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_create_acount)
        }
        mBinding.txtRecoverPassword.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_recover_password)
        }
    }
}