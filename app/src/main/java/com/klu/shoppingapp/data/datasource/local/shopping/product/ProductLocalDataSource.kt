package com.klu.shoppingapp.data.datasource.local.shopping.product

import com.klu.shoppingapp.common.Response
import com.klu.shoppingapp.model.shopping.ProductEntity

interface ProductLocalDataSource {

    suspend fun addProduct(productEntity: ProductEntity): Response<Unit>

    suspend fun getAllProducts(): Response<List<ProductEntity>>
}