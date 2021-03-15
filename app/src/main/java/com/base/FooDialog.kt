package com.base

import android.content.Context
import android.os.Bundle
import com.base.databinding.DialogFooBinding
import com.viewbinding.base.BaseBindingDialog

class FooDialog(context: Context) :
    BaseBindingDialog<DialogFooBinding>(context, DialogFooBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            tvName.text = "dialog foo"
        }
    }
}