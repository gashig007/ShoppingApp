package com.geektech.shoppingapplication.domain

import com.geektech.shoppingapplication.domain.entity.ShopItem

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItemId: Int): ShopItem

    //можно изменять
    fun getShopList(): List<ShopItem>
}