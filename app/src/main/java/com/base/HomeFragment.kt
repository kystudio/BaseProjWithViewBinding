package com.base

import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import com.base.databinding.FragmentHomeBinding
import com.base.databinding.ItemFooBinding
import com.viewbinding.base.BaseBindingFragment
import com.viewbinding.ext.ListAdapter
import com.viewbinding.ext.onBinding
import com.viewbinding.ext.onItemClick

class HomeFragment : BaseBindingFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun initData() {
        binding.titleBar.tvTitle.text = "ViewBinding Demo"
        binding.titleBar.ivReturn.visibility = View.VISIBLE
        binding.titleBar.ivReturn.setOnClickListener {
            Toast.makeText(activity, "return", Toast.LENGTH_SHORT).show()
        }
        binding.tvInfo.text = "HomeFragment by viewBinding"

        val data = mutableListOf(Foo("s1"), Foo("s2"), Foo("s3"), Foo("s4"))

        val foo2Adapter = Foo2Adapter()
        foo2Adapter.data = data
        foo2Adapter.setOnItemClickListener { _, _, position ->
            Toast.makeText(
                requireContext(),
                "foo2Adapter 点击了${data[position].name}, position: $position",
                Toast.LENGTH_SHORT
            ).show()
        }

        val foo4Adapter = Foo4Adapter()
        foo4Adapter.submitList(data)
        foo4Adapter.onItemClick = {
            Toast.makeText(
                requireContext(),
                "foo4Adapter 点击了${data[it].name}, position: $it",
                Toast.LENGTH_SHORT
            )
                .show()
        }

        val diffCallback = object : DiffUtil.ItemCallback<Foo>() {
            override fun areItemsTheSame(oldItem: Foo, newItem: Foo): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Foo, newItem: Foo): Boolean {
                return oldItem.name == newItem.name
            }
        }
        val foo5Adapter = ListAdapter(ItemFooBinding::inflate, diffCallback) {
            onBinding {
                binding.tvName.text = data[it].name
            }
            onItemClick {
                Toast.makeText(
                    requireContext(),
                    "foo5Adapter 点击了${data[it].name}, position: $it",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
        foo5Adapter.submitList(data)

        binding.rvInfo.adapter = foo4Adapter

        Handler(Looper.getMainLooper()).postDelayed({
            val oldData = foo4Adapter.currentList
            data.add(1,Foo("s5"))
            data.add(3,Foo("s6"))
            foo4Adapter.submitList(data) {
                val diffResult = DiffUtil
                    .calculateDiff(MyDiffCallback(oldData, data))
                diffResult.dispatchUpdatesTo(foo4Adapter)
            }
        }, 3000)
    }
}