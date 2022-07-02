package com.geektech.shoppingapplication.domain

import com.geektech.shoppingapplication.domain.entity.ShopItem

class DeleteShopItemUseCase (private val shopListRepository: ShopListRepository) {
    fun deleteShopItem(shopItem: ShopItem){
        shopListRepository.deleteShopItem(shopItem)
    }
}