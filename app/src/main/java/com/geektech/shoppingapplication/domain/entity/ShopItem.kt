package com.geektech.shoppingapplication.domain.entity

data class ShopItem(
    val name: String?,
    val count: Int?,
    var enable: Boolean,
    var id: Int = UNEFINED_ID
){
    companion object{
        const val UNEFINED_ID = 0
    }
}

