package com.base

import com.base.databinding.ItemFooBinding
import com.viewbinding.base.BaseBindingQuickAdapter

class Foo2Adapter : BaseBindingQuickAdapter<Foo, ItemFooBinding>(ItemFooBinding::inflate) {
    override fun convert(holder: BaseBindingHolder, item: Foo) {
        holder.getViewBinding<ItemFooBinding>().apply {
            tvName.text = item.name
        }
    }
}