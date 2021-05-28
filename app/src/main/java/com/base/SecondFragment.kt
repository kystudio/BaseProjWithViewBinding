package com.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.base.databinding.FragmentSecondBinding
import com.viewbinding.ext.BindingLifecycleOwner
import com.viewbinding.ext.binding

class SecondFragment : Fragment(R.layout.fragment_second), BindingLifecycleOwner {

    private val secondBinding by binding(FragmentSecondBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        secondBinding.tvInfoFragment.text = "Hello SecondFragment!"
    }

    override fun onDestroyViewBinding(destroyingBinding: ViewBinding) {
        if (destroyingBinding is FragmentSecondBinding) {

        }
    }

}