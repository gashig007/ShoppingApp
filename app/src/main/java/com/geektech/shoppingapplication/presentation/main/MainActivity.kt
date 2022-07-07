package com.geektech.shoppingapplication.presentation.main

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.geektech.shoppingapplication.databinding.ActivityMainBinding
import com.geektech.shoppingapplication.domain.entity.ShopItem

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        initListener()
    }

    private fun initListener() {
        binding.btnAdd.setOnClickListener {
            Log.d(TAG, "add:  ${viewModel.addShopItem(ShopItem(binding.etTitle.text.toString(), 77, false))}")

        }

        binding.btnDelete.setOnClickListener {
            Log.d(TAG, "delete: ${viewModel.deleteShopItem(ShopItem(binding.etTitle.text.toString(), 77, false, 0))}")
        }

        binding.btnEdit.setOnClickListener {
            Log.d(TAG, "edit: ${viewModel.editShopItem(ShopItem(binding.etTitle.text.toString(), 77, false, 0))}")
        }

        binding.btnGetItem.setOnClickListener {
            Log.d(TAG, "getItem: ${viewModel.getShopItem(ShopItem(binding.etTitle.text.toString(), 77, false, 0))}")
        }

        binding.btnGetList.setOnClickListener {
            Log.d(TAG, "getList: " + viewModel.getShopList().toString())
            println(viewModel.getShopList().toString())
        }
    }
}