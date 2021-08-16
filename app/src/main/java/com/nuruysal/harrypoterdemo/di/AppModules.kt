package com.nuruysal.harrypoterdemo.di

import com.nuruysal.harrypoterdemo.app.adapter.ProductsRecycleAdapter
import com.nuruysal.harrypoterdemo.app.view.UiMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dependency Injection Configurations
 */

@Module
@InstallIn(SingletonComponent::class)
class AppModules {

    @Singleton
    @Provides
    fun bindUiMapper() = UiMapper()

    @Singleton
    @Provides
    fun bindProductsRecycleAdapter() = ProductsRecycleAdapter()


}