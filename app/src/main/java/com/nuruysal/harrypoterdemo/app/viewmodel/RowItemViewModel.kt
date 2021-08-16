package com.nuruysal.harrypoterdemo.app.viewmodel

import com.nuruysal.harrypoterdemo.base.VMBase

/**
 * Created by serifenuruysal on 8/1/21.
 */

data class RowItemViewModel(
    val title: String?,
    val imageUrl: String?,
    val author: String?,
    var isFavorite: Boolean? = false
) : VMBase()