package com.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.base.databinding.ItemFooBinding
import com.viewbinding.ext.BindingViewHolder

class FooAdapter(private var list: List<Foo>) :
    RecyclerView.Adapter<BindingViewHolder<ItemFooBinding>>() {
    lateinit var onItemClick: ((Foo, Int) -> Unit)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<ItemFooBinding> {
        return BindingViewHolder(parent, ItemFooBinding::inflate)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<ItemFooBinding>, position: Int) {
        val foo = list[position]
        holder.binding.apply {
            tvName.text = foo.name
        }
        holder.itemView.setOnClickListener {
            onItemClick(foo, position)
        }
    }

    override fun getItemCount(): Int = list.size
}