package com.base

import com.base.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun initData() {
        setStatusBar(0)
        binding.tvInfoActivity.text = "MainActivity by viewBinding"
    }
}