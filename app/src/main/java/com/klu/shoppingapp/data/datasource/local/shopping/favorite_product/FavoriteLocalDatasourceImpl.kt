package com.klu.shoppingapp.data.datasource.local.shopping.favorite_product

import com.klu.shoppingapp.common.Response
import com.klu.shoppingapp.common.caller.dbCall
import com.klu.shoppingapp.data.datasource.local.shopping.favorite_product.db.FavoriteProductDao
import com.klu.shoppingapp.model.shopping.ProductEntity
import javax.inject.Inject

class FavoriteLocalDatasourceImpl @Inject constructor(
    private val favoriteProductDao: FavoriteProductDao
) : FavoriteProductLocalDatasource {

    override suspend fun addFavoriteProduct(productEntity: ProductEntity): Response<Unit> {
        return dbCall { favoriteProductDao.addFavoriteProduct(productEntity) }
    }

    override suspend fun getAllFavoriteProducts(): Response<List<ProductEntity>> {
        return dbCall { favoriteProductDao.getAllFavoriteProducts() }
    }

    override suspend fun findFavoriteProduct(productId: Int): Response<ProductEntity?> {
        return dbCall { favoriteProductDao.findFavoriteProduct(productId) }
    }

    override suspend fun removeFavoriteProduct(productId: Int): Response<Unit> {
        return dbCall { favoriteProductDao.removeFavoriteProduct(productId) }
    }
}