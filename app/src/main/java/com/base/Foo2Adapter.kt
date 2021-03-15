package com.base

import com.base.databinding.ItemFooBinding
import com.viewbinding.base.BaseBindingQuickAdapter

class Foo2Adapter : BaseBindingQuickAdapter<Foo, ItemFooBinding>(ItemFooBinding::inflate) {
    override fun convert(binding: ItemFooBinding, position: Int, item: Foo) {
        binding.tvName.text = item.name
    }
}