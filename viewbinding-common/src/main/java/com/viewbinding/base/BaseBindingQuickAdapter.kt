@file:Suppress("unused")

package com.viewbinding.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder


abstract class BaseBindingQuickAdapter<T, VB : ViewBinding>(
    private val inflate: (LayoutInflater, ViewGroup, Boolean) -> VB,
    layoutResId: Int = -1
) :
    BaseQuickAdapter<T, BaseBindingQuickAdapter.BaseBindingHolder<VB>>(layoutResId) {

    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): BaseBindingHolder<VB> =
        BaseBindingHolder(inflate(LayoutInflater.from(parent.context), parent, false))

    override fun convert(holder: BaseBindingHolder<VB>, item: T) {
        convert(holder.binding, holder.layoutPosition, item)
    }

    abstract fun convert(binding: VB, position: Int, item: T)

    class BaseBindingHolder<VB : ViewBinding>(val binding: VB) : BaseViewHolder(binding.root)
}