package com.nuruysal.harrypoterdemo.app.viewmodel

import androidx.databinding.ObservableField
import com.nuruysal.harrypoterdemo.app.view.UiMapper
import com.nuruysal.harrypoterdemo.base.BaseResult
import com.nuruysal.harrypoterdemo.base.BaseViewModel
import com.nuruysal.harrypoterdemo.domain.GetDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by serifenuruysal on 8/5/21.
 *
 *
 * Provides the data for ui and handle user interaction with data
 *
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDataUseCase: GetDataUseCase,
    private val uiMapper: UiMapper
) : BaseViewModel<MainViewState>() {

    var isSelectedProductFavorite = ObservableField(false)

    init {
        getProductList()
    }

    private fun getProductList() {
        when (val result = getDataUseCase.execute()) {
            is BaseResult.Success -> {
                result.data?.let {
                    uiState.value =
                        MainViewState.ProductListLoaded(
                            uiMapper.mapProductToUiModel(result.data),
                            uiState.value?.selectedProduct
                        )
                }
            }
            is BaseResult.Error<*> -> {
                MainViewState.Error(
                    result.errorResponse,
                    uiState.value?.productList,
                    uiState.value?.selectedProduct
                )

            }
            is BaseResult.Loading<*> -> {
                MainViewState.Loading(
                    uiState.value?.productList,
                    uiState.value?.selectedProduct
                )
            }
        }
    }

    fun setSelectedProduct(selectedProduct: RowItemViewModel) {
        isSelectedProductFavorite.set(selectedProduct.isFavorite ?: false)

        uiState.value = MainViewState.ProductSelected(
            uiState.value?.productList,
            selectedProduct
        )
    }


    fun setSelectedProductFavoriteUnFavorite() {
        val selectedProduct = uiState.value?.selectedProduct
        val isFavoriteCurrentProduct = uiState.value?.selectedProduct?.isFavorite ?: false
        val updatedList = uiState.value?.productList

        updatedList?.forEach {
            if (selectedProduct?.title.equals(it.title)) {
                it.apply {
                    Timber.d("favorite changed: ${isFavoriteCurrentProduct.not()}")
                    this.isFavorite = isFavoriteCurrentProduct.not()
                }
            }
        }
        selectedProduct?.apply {
            this.isFavorite = isFavoriteCurrentProduct.not()
        }

        isSelectedProductFavorite.set(selectedProduct?.isFavorite ?: false)
        uiState.value = MainViewState.ProductListLoaded(
            updatedList,
            selectedProduct
        )
    }

    fun getSelectedProduct(): RowItemViewModel? = uiState.value?.selectedProduct

}