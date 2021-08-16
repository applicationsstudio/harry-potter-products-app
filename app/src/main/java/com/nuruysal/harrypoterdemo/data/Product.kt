package com.nuruysal.harrypoterdemo.data

import com.google.gson.annotations.SerializedName

/**
 * Created by serifenuruysal on 8/1/21.
 */
data class Product(
    @SerializedName("title")
    val title: String?,
    @SerializedName("imageURL")
    val imageURL: String?,
    @SerializedName("author")
    val author: String?
)