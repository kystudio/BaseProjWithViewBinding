package com.base

import androidx.recyclerview.widget.DiffUtil

class MyDiffCallback(private val oldList: MutableList<Foo>, private val newList: MutableList<Foo>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].javaClass == newList[newItemPosition].javaClass
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldStr = oldList[oldItemPosition]
        val newStr = newList[newItemPosition]
        return oldStr == newStr
    }
}