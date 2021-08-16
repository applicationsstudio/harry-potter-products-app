package com.nuruysal.harrypoterdemo.app.viewmodel

import com.nuruysal.harrypoterdemo.base.BaseViewState

/**
 * Created by serifenuruysal on 8/1/21.
 */

sealed class MainViewState : BaseViewState() {
    abstract val productList: List<RowItemViewModel>?
    abstract var selectedProduct: RowItemViewModel?

    data class Loading(
        override val productList: List<RowItemViewModel>? = arrayListOf(),
        override var selectedProduct: RowItemViewModel?

    ) : MainViewState()

    data class ProductListLoaded(
        override val productList: List<RowItemViewModel>? = arrayListOf(),
        override var selectedProduct: RowItemViewModel?
    ) : MainViewState()

    data class ProductSelected(
        override val productList: List<RowItemViewModel>? = arrayListOf(),
        override var selectedProduct: RowItemViewModel?
    ) : MainViewState()

    data class Error(
        val error: Throwable?,
        override val productList: List<RowItemViewModel>? = arrayListOf(),
        override var selectedProduct: RowItemViewModel?
    ) : MainViewState()
}