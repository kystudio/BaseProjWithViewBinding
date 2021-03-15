package com.base

import android.view.View
import android.widget.Toast
import com.base.databinding.FragmentHomeBinding
import com.viewbinding.base.BaseBindingFragment

class HomeFragment : BaseBindingFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun initData() {
        binding.titleBar.tvTitle.text = "ViewBinding Demo"
        binding.titleBar.ivReturn.visibility = View.VISIBLE
        binding.titleBar.ivReturn.setOnClickListener {
            Toast.makeText(activity, "return", Toast.LENGTH_SHORT).show()
        }
        binding.tvInfo.text = "HomeFragment by viewBinding"
    }
}