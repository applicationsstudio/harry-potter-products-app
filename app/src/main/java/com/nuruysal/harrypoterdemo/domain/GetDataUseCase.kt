package com.nuruysal.harrypoterdemo.domain

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.nuruysal.harrypoterdemo.base.BaseResult
import com.nuruysal.harrypoterdemo.base.BaseUseCase
import com.nuruysal.harrypoterdemo.data.JsonParser
import com.nuruysal.harrypoterdemo.data.Product
import java.util.*
import javax.inject.Inject

/**
 * Created by serifenuruysal on 8/1/21.
 */
class GetDataUseCase @Inject constructor() : BaseUseCase<List<Product>> {

    @Inject
    internal lateinit var jsonParser: JsonParser

    /**
     * UseCase for converting json string to Product items list
     */
    override fun execute(): BaseResult.Success<List<Product>> {
        val jsonString = jsonParser.loadJSONFromAsset()
        val gson = GsonBuilder().create()
        val productList = gson.fromJson<List<Product>>(jsonString, object :
            TypeToken<ArrayList<Product>>() {}.type)
        return BaseResult.Success(productList)
    }


}
