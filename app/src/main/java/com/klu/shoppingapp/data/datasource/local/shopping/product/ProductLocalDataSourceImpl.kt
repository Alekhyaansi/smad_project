package com.klu.shoppingapp.data.datasource.local.shopping.product

import com.klu.shoppingapp.common.Response
import com.klu.shoppingapp.common.caller.dbCall
import com.klu.shoppingapp.data.datasource.local.shopping.product.db.ProductDao
import com.klu.shoppingapp.model.shopping.ProductEntity
import javax.inject.Inject

class ProductLocalDataSourceImpl @Inject constructor(private val productDao: ProductDao) :
    ProductLocalDataSource {

    override suspend fun addProduct(productEntity: ProductEntity): Response<Unit> {
        return dbCall { productDao.addProduct(productEntity) }
    }

    override suspend fun getAllProducts(): Response<List<ProductEntity>> {
        return dbCall { productDao.getAllProducts() }
    }
}