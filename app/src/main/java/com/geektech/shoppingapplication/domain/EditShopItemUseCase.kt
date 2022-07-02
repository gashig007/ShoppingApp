package com.geektech.shoppingapplication.domain

import com.geektech.shoppingapplication.domain.entity.ShopItem

class EditShopItemUseCase (private val shopListRepository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem){
        shopListRepository.editShopItem(shopItem)
    }
}