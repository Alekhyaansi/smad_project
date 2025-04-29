package com.klu.shoppingapp.data.datasource.remote.shopping

import com.klu.shoppingapp.common.Response
import com.klu.shoppingapp.common.caller.apiCall
import com.klu.shoppingapp.data.datasource.remote.api.ShoppingApi
import com.klu.shoppingapp.model.shopping.Product
import javax.inject.Inject

class ShoppingRemoteDataSourceImpl @Inject constructor(
    private val api: ShoppingApi
): ShoppingRemoteDataSource {

    override suspend fun getCategories(): Response<List<String>> = apiCall { api.getCategories() }

    override suspend fun getProducts(): Response<List<Product>> = apiCall { api.getProducts() }
}