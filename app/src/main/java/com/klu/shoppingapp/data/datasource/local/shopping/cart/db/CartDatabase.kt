package com.klu.shoppingapp.data.datasource.local.shopping.cart.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.klu.shoppingapp.model.shopping.CartEntity

@Database(entities = [CartEntity::class], version = 1)
abstract class CartDatabase : RoomDatabase() {

    abstract fun cartDao(): CartDao
}