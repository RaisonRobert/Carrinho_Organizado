package com.carrinhoorganizado.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.carrinhoorganizado.databinding.FragmentCreateAcountBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateAcountFragment : Fragment() {
    private var _binding: FragmentCreateAcountBinding? = null
    private val mBinding get() = _binding!!
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
    }

    private fun setupOnClick() {

    }
}