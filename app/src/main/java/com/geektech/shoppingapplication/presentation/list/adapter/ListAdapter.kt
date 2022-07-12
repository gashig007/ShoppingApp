package com.geektech.shoppingapplication.presentation.list.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.shoppingapplication.R
import com.geektech.shoppingapplication.databinding.ItemShopDisabledBinding
import com.geektech.shoppingapplication.databinding.ItemShopEnabledBinding
import com.geektech.shoppingapplication.domain.entity.ShopItem

class ListAdapter(private val onClick: ((shopItem: ShopItem) -> Boolean)? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list1 = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_shop_disabled -> {
                ViewHolderDiss(
                    ItemShopDisabledBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            R.layout.item_shop_enabled -> {
                ViewHolderEnabled(
                    ItemShopEnabledBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list1[position]
        when (getItemViewType(position)) {
            R.layout.item_shop_enabled -> (holder as ViewHolderEnabled).bind(item)
            R.layout.item_shop_disabled -> (holder as ViewHolderDiss).bind(item)
        }
    }


    override fun getItemCount(): Int {
        return list1.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (list1[position].enable) {
            true -> R.layout.item_shop_enabled
            false -> R.layout.item_shop_disabled
        }

    }

    inner class ViewHolderEnabled(private val binding: ItemShopEnabledBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(shopItem: ShopItem) = binding.apply {
            binding.tvName.text = shopItem.name
            binding.tvCount.text = shopItem.count.toString()
            root.setOnClickListener {
                shopItem.enable = false
                notifyItemChanged(adapterPosition)
            }
        }
    }

    inner class ViewHolderDiss(private val binding: ItemShopDisabledBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(shopItem: ShopItem) = binding.apply {
            binding.tvName.text = shopItem.name
            binding.tvCount.text = shopItem.count.toString()
            root.setOnClickListener {
                shopItem.enable = true
                notifyItemChanged(adapterPosition)

            }
        }
    }

}