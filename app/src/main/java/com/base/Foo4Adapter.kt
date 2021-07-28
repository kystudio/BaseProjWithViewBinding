package com.base

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.base.databinding.ItemFooBinding
import com.viewbinding.ext.BindingViewHolder
import com.viewbinding.ext.onItemClick


class Foo4Adapter : ListAdapter<Foo, BindingViewHolder<ItemFooBinding>>(DiffCallback()) {
    lateinit var onItemClick: ((Foo, Int) -> Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BindingViewHolder(parent, ItemFooBinding::inflate)

    override fun onBindViewHolder(holder: BindingViewHolder<ItemFooBinding>, position: Int) {
        holder.onItemClick {
            onItemClick(currentList[position], position)
        }
        holder.binding.apply {
            tvName.text = currentList[position].name
        }
    }
}