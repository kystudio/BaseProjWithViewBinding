@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package com.viewbinding.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


abstract class BaseBindingFragment<VB : ViewBinding>(
    private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment() {

    private var _binding: VB? = null
    val binding: VB get() = _binding!!
    private var _activity: AppCompatActivity? = null
    val mActivity: AppCompatActivity get() = _activity!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        _activity = context as AppCompatActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    abstract fun initData()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}