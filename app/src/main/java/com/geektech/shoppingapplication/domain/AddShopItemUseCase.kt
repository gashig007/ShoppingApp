package com.geektech.shoppingapplication.domain

import com.geektech.shoppingapplication.domain.entity.ShopItem

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopItem(shopItem: ShopItem){
        shopListRepository.addShopItem(shopItem)
    }
}