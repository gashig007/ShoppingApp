package com.geektech.shoppingapplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        initData()
    }

    private fun initData() {
        viewModel.shopList.observe(this){
            print(it)
        }

        for (i in 0..10){
            viewModel.addShopItem(ShopItem("potato", i, false))
        }
        viewModel.getShopItem()
    }
}