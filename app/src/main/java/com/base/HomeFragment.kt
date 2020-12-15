package com.base

import android.view.View
import com.base.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun initBinding(view: View): FragmentHomeBinding = FragmentHomeBinding.bind(view)

    override fun init() {
        binding.tvInfo.text = "HomeFragment by viewBinding"
    }
}