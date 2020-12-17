package com.base

import android.view.View
import com.base.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun initData() {
//        setStatusBar(1)
        binding.tvInfo.text = "MainActivity by viewBinding"
        binding.titleBar.tvTitle.text = "ViewBinding Demo"
        binding.titleBar.ivReturn.visibility = View.VISIBLE
        binding.titleBar.ivReturn.setOnClickListener { finish() }
    }
}