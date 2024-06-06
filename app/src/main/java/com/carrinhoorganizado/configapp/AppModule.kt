package com.carrinhoorganizado.configapp

import com.carrinhoorganizado.repository.ShoppingCartRepository
import com.carrinhoorganizado.repository.ShoppingCartRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object AppModule {
    @Provides
    fun provideShoppingCartRepository() : ShoppingCartRepositoryInterface {
        return ShoppingCartRepository()
    }
}