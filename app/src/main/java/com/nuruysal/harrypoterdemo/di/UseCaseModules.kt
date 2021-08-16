package com.nuruysal.harrypoterdemo.di

import android.content.Context
import com.nuruysal.harrypoterdemo.base.BaseUseCase
import com.nuruysal.harrypoterdemo.data.JsonParser
import com.nuruysal.harrypoterdemo.data.Product
import com.nuruysal.harrypoterdemo.domain.GetDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


/**
 * Dependency Injection Configurations
 */

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModules {

    @Provides
    fun getJsonParser(@ApplicationContext context: Context) = JsonParser(context)

    @Provides
    fun provideGetDataUseCase(): BaseUseCase<List<Product>> = GetDataUseCase()

}



