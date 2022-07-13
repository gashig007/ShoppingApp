package com.geektech.shoppingapplication.presentation.list.adapter

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.geektech.shoppingapplication.R
import com.geektech.shoppingapplication.databinding.ItemShopDisabledBinding
import com.geektech.shoppingapplication.databinding.ItemShopEnabledBinding
import com.geektech.shoppingapplication.domain.entity.ShopItem
import com.geektech.shoppingapplication.presentation.list.ListActivity
import com.geektech.shoppingapplication.presentation.main.MainViewModel

class ListAdapter(private val onClick: ((shopItem: ShopItem) -> Boolean)? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list = listOf<ShopItem>()
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
        val item = list[position]
        when (getItemViewType(position)) {
            R.layout.item_shop_enabled -> (holder as ViewHolderEnabled).bind(item)
            R.layout.item_shop_disabled -> (holder as ViewHolderDiss).bind(item)
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position].enable) {
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

            root.setOnLongClickListener {
                val item = list[position]
                Log.e(TAG, "Item: $item")
                true
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

            root.setOnLongClickListener {
                val item = list[position]
                Log.e(TAG, "Item: $item")
                true
            }
        }
    }
}