package com.geektech.shoppingapplication.domain

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList() = shopListRepository.getShopList()
}