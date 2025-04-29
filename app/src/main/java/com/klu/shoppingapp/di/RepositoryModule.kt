package com.klu.shoppingapp.di

import com.klu.shoppingapp.data.datasource.local.shopping.cart.CartLocalDataSource
import com.klu.shoppingapp.data.datasource.local.shopping.favorite_product.FavoriteProductLocalDatasource
import com.klu.shoppingapp.data.datasource.local.shopping.product.ProductLocalDataSource
import com.klu.shoppingapp.data.datasource.remote.firebase.auth.FirebaseAuthDataSource
import com.klu.shoppingapp.data.datasource.remote.firebase.fcm.FirebaseFcmDataSource
import com.klu.shoppingapp.data.datasource.remote.firebase.storage.FirebaseStorageDataSource
import com.klu.shoppingapp.data.datasource.remote.firebase.store.FirebaseFirestoreDataSource
import com.klu.shoppingapp.data.datasource.remote.shopping.ShoppingRemoteDataSource
import com.klu.shoppingapp.domain.repository.FirebaseRepository
import com.klu.shoppingapp.data.repository.FirebaseRepositoryImpl
import com.klu.shoppingapp.domain.repository.ShoppingRepository
import com.klu.shoppingapp.data.repository.ShoppingRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideFirebaseRepository(
        authDataSource: FirebaseAuthDataSource,
        storageDataSource: FirebaseStorageDataSource,
        firestoreDataSource: FirebaseFirestoreDataSource,
        fcmDataSource: FirebaseFcmDataSource
    ): FirebaseRepository {
        return FirebaseRepositoryImpl(
            authDataSource,
            storageDataSource,
            firestoreDataSource,
            fcmDataSource
        )
    }

    @Provides
    @Singleton
    fun provideShoppingRepository(
        remoteDataSource: ShoppingRemoteDataSource,
        productLocalDataSource: ProductLocalDataSource,
        favoriteProductLocalDatasource: FavoriteProductLocalDatasource,
        cartLocalDataSource: CartLocalDataSource
    ): ShoppingRepository {
        return ShoppingRepositoryImpl(
            remoteDataSource,
            productLocalDataSource,
            favoriteProductLocalDatasource,
            cartLocalDataSource
        )
    }
}