package com.geektech.shoppingapplication.data.entity

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShopItemDao {
    @Query("SELECT * FROM shop_table")
    fun getShopList() : List<ShopItemDB>

    @Insert
    fun addShopItem(shopItemDB: ShopItemDB)

    @Delete
    fun deleteShopItem(shopItemDB: ShopItemDB)
}