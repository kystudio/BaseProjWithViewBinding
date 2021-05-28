package com.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.base.databinding.ActivitySecondBinding
import com.viewbinding.ext.binding

class SecondActivity : AppCompatActivity() {
    private val binding by binding(ActivitySecondBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.tvInfoActivity.text = "SecondActivity"
    }
}