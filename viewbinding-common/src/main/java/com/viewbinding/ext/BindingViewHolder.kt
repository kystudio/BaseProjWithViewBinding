@file:Suppress("unused")

package com.viewbinding.ext

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


class BindingViewHolder<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root) {

    constructor(block: (LayoutInflater, ViewGroup, Boolean) -> VB, parent: ViewGroup) :
            this(block(LayoutInflater.from(parent.context), parent, false))
}
