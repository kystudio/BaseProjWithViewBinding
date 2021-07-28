package com.base

import android.view.View
import android.widget.Toast
import com.base.databinding.FragmentHomeBinding
import com.base.databinding.ItemFooBinding
import com.viewbinding.base.BaseBindingFragment
import com.viewbinding.ext.ListAdapter
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

        val fooAdapter = FooAdapter(data)
        fooAdapter.onItemClick = { foo, pos ->
            Toast.makeText(
                requireContext(),
                "fooAdapter 点击了${foo.name}, position: $pos",
                Toast.LENGTH_SHORT
            ).show()
        }

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
        foo4Adapter.onItemClick = { foo, pos ->
            Toast.makeText(
                requireContext(),
                "foo4Adapter 点击了${foo.name}, position: $pos",
                Toast.LENGTH_SHORT
            )
                .show()
        }

        val foo5Adapter = ListAdapter(DiffCallback(), ItemFooBinding::inflate) { item ->
            binding.tvName.text = item.name
            onItemClick {
                Toast.makeText(
                    requireContext(),
                    "foo5Adapter 点击了${item.name}, position: $it",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
        foo5Adapter.submitList(data)

        foo2Adapter.setDiffCallback(DiffCallback())

        binding.rvInfo.adapter = foo4Adapter

        binding.tvInfo.setOnClickListener {
            val newData =
                mutableListOf(Foo("s1"), Foo("s2"), Foo("s5"), Foo("s6"), Foo("s3"), Foo("s4"))
            foo4Adapter.submitList(newData)
//            foo2Adapter.setDiffNewData(newData)
        }
    }
}