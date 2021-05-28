package com.base

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.base.databinding.ItemFooBinding
import com.viewbinding.ext.BindingViewHolder
import com.viewbinding.ext.onBinding
import com.viewbinding.ext.onItemClick


class Foo4Adapter : ListAdapter<Foo, BindingViewHolder<ItemFooBinding>>(DiffCallback()) {
    lateinit var onItemClick: ((Int) -> Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BindingViewHolder(ItemFooBinding::inflate, parent)

    override fun onBindViewHolder(holder: BindingViewHolder<ItemFooBinding>, position: Int) {
        holder.onItemClick {
            onItemClick(position)
        }
        holder.onBinding {
            tvName.text = currentList[position].name
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Foo>() {
        override fun areItemsTheSame(oldItem: Foo, newItem: Foo) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Foo, newItem: Foo) = oldItem.name == newItem.name
    }
}