package com.geektech.shoppingapplication.data.entity

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ShopItemDB::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun dao() : ShopItemDao
}