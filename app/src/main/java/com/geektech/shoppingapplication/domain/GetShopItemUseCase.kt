package com.geektech.shoppingapplication.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItem(shopItemId: Int) = shopListRepository.getShopItem(shopItemId)
}