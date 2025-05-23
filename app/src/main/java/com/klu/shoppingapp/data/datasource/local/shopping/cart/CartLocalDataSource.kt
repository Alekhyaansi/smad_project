package com.klu.shoppingapp.data.datasource.local.shopping.cart

import com.klu.shoppingapp.common.Response
import com.klu.shoppingapp.model.shopping.CartEntity

interface CartLocalDataSource {

    suspend fun addProductToCart(cartEntity: CartEntity): Response<Unit>

    suspend fun removeProductFromCart(productId: Int): Response<Unit>

    suspend fun getCart(): Response<List<CartEntity>>

    suspend fun findCartItem(productId: Int): Response<CartEntity?>

    suspend fun increaseCartItemCount(cartItemId: Int): Response<Unit>

    suspend fun decreaseCartItemCount(cartItemId: Int): Response<Unit>

    suspend fun deleteAllItemsFromCart(): Response<Unit>
}