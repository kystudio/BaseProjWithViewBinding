package com.base

import androidx.recyclerview.widget.DiffUtil

data class Foo(val name: String)

class DiffCallback : DiffUtil.ItemCallback<Foo>() {
    override fun areItemsTheSame(oldItem: Foo, newItem: Foo) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Foo, newItem: Foo) = oldItem.name == newItem.name
}