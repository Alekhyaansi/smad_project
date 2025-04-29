package com.klu.shoppingapp.data.datasource.remote.api

import com.klu.shoppingapp.model.shopping.Product
import com.klu.shoppingapp.utils.EndPoints
import retrofit2.http.GET

interface ShoppingApi {

    @GET(EndPoints.CATEGORY)
    suspend fun getCategories(): ArrayList<String>

    @GET(EndPoints.PRODUCT)
    suspend fun getProducts(): List<Product>
}