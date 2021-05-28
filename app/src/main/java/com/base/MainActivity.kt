package com.base

import android.content.Intent
import com.base.databinding.ActivityMainBinding
import com.viewbinding.base.BaseBindingActivity

class MainActivity : BaseBindingActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun initData() {
        setStatusBar(0)
        binding.tvInfoActivity.text = "MainActivity by viewBinding"
        binding.tvInfoActivity.setOnClickListener {
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
        }
    }
}