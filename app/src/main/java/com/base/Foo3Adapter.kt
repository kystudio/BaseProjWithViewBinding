package com.base

import android.view.ViewGroup
import com.base.databinding.ItemFooBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.viewbinding.ext.getViewBinding
import com.viewbinding.ext.withBinding

class Foo3Adapter : BaseQuickAdapter<Foo, BaseViewHolder>(R.layout.item_foo) {

    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return super.onCreateDefViewHolder(parent, viewType)
            .withBinding { ItemFooBinding.bind(it) }
    }

    override fun convert(holder: BaseViewHolder, item: Foo) {
        holder.getViewBinding<ItemFooBinding>()
            .apply {
                tvName.text = item.name
            }
    }

}