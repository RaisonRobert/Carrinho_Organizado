package com.carrinhoorganizado.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.carrinhoorganizado.R
import com.carrinhoorganizado.databinding.FragmentLoginBinding
import com.carrinhoorganizado.view.activity.HomeActivity

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val mBinding get() = _binding!!
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
    }

    private fun setupOnClick() {
        mBinding.btnLogin.setOnClickListener {
            startActivity(Intent(requireContext(), HomeActivity::class.java))
        }
        mBinding.txtCreateAcount.setOnClickListener{
            findNavController().navigate(R.id.action_login_to_create_acount)
        }
        mBinding.txtRecoverPassword.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_recover_password)
        }
    }
}