package com.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.base.databinding.ItemFooBinding
import com.viewbinding.ext.BindingViewHolder

class FooAdapter(private val list: List<Foo>) : RecyclerView.Adapter<BindingViewHolder<ItemFooBinding>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<ItemFooBinding> {
        return BindingViewHolder(ItemFooBinding::inflate, parent)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<ItemFooBinding>, position: Int) {
        val foo = list[position]
        holder.binding.apply {
            tvName.text = foo.name
        }
    }

    override fun getItemCount(): Int = list.size
}