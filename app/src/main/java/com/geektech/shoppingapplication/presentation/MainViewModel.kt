package com.geektech.shoppingapplication.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.shoppingapplication.data.ShopListRepositoryImpl
import com.geektech.shoppingapplication.domain.AddShopItemUseCase
import com.geektech.shoppingapplication.domain.GetShopListUseCase
import com.geektech.shoppingapplication.domain.entity.ShopItem

class MainViewModel: ViewModel() {
    private val repository = ShopListRepositoryImpl()

    private val getShopListUseCase = GetShopListUseCase(repository)

    private val addShopItemUseCase = AddShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun addShopItem(shopItem: ShopItem) {
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun getShopItem() {
        shopList.value = getShopListUseCase.getShopList()
    }
}