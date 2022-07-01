package com.geektech.shoppingapplication.data

import com.geektech.shoppingapplication.domain.ShopListRepository
import com.geektech.shoppingapplication.domain.entity.ShopItem

class ShopListRepositoryImpl: ShopListRepository {
        private val shopList = mutableListOf<ShopItem>()

    override fun addShopItem(shopItem: ShopItem) {
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        TODO("Not yet implemented")
    }

    override fun editShopItem(shopItem: ShopItem) {
        TODO("Not yet implemented")
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        TODO("Not yet implemented")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}