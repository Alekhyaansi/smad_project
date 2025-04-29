package com.klu.shoppingapp.data.datasource.remote.shopping

import com.klu.shoppingapp.common.Response
import com.klu.shoppingapp.model.shopping.Product

interface ShoppingRemoteDataSource {

    suspend fun getCategories(): Response<List<String>>

    suspend fun getProducts(): Response<List<Product>>
}