package com.geektech.shoppingapplication.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_table")
data class ShopItemDB (
    @PrimaryKey(autoGenerate = true)
    var Id: Int,
    val name: String?,
    val count: Int?,
    var enable: Boolean,
)

