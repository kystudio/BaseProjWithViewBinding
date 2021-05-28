@file:Suppress("unused")

package com.viewbinding.ext

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class BindingViewHolder<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root) {
    constructor(inflate: (LayoutInflater, ViewGroup, Boolean) -> VB, parent: ViewGroup) :
            this(inflate(LayoutInflater.from(parent.context), parent, false))
}

inline fun <VB : ViewBinding> BindingViewHolder<VB>.onBinding(crossinline action: VB.(Int) -> Unit) =
    apply { binding.action(adapterPosition) }

inline fun <VB : ViewBinding> BindingViewHolder<VB>.onItemClick(crossinline action: VB.(Int) -> Unit) =
    apply { itemView.setOnClickListener { binding.action(adapterPosition) } }

inline fun <T, reified VB : ViewBinding> ListAdapter(
    noinline inflate: (LayoutInflater, ViewGroup, Boolean) -> VB,
    diffCallback: DiffUtil.ItemCallback<T>,
    crossinline onBindViewHolder: BindingViewHolder<VB>.(T) -> Unit
) = object : ListAdapter<T, BindingViewHolder<VB>>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BindingViewHolder(inflate, parent)

    override fun onBindViewHolder(holder: BindingViewHolder<VB>, position: Int) {
        onBindViewHolder(holder, currentList[position])
    }
}