package com.nuruysal.harrypoterdemo.app.view

import com.nuruysal.harrypoterdemo.app.viewmodel.RowItemViewModel
import com.nuruysal.harrypoterdemo.data.Product
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by serifenuruysal on 3.08.2021.
 */

@Singleton
class UiMapper @Inject constructor() {
    fun mapProductToUiModel(productList: List<Product>): List<RowItemViewModel> {
        return productList.map {
            RowItemViewModel(
                title = it.title,
                author = it.author,
                imageUrl = it.imageURL
            )
        }
    }
}