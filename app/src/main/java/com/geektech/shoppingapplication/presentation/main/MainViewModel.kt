package com.geektech.shoppingapplication.presentation.main

import androidx.lifecycle.ViewModel
import com.geektech.shoppingapplication.data.ShopListRepositoryImpl
import com.geektech.shoppingapplication.domain.*
import com.geektech.shoppingapplication.domain.entity.ShopItem

class MainViewModel : ViewModel() {
    private val repository = ShopListRepositoryImpl()

    private val getShopListUseCase = GetShopListUseCase(repository)

    private val addShopItemUseCase = AddShopItemUseCase(repository)

    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

    private val editShopItemUseCase = EditShopItemUseCase(repository)

    private val getShopItemUseCase = GetShopItemUseCase(repository)

    fun addShopItem(shopItem: ShopItem) {
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem) {
        val newItem = ShopItem("tomato", 77, enable = !shopItem.enable, 0)
        editShopItemUseCase.editShopItem(newItem)
    }

    fun getShopList() = getShopListUseCase.getShopList()

    fun getShopItem(shopItem: ShopItem) : ShopItem {
       return getShopItemUseCase.getShopItem(shopItem.id)
    }
}