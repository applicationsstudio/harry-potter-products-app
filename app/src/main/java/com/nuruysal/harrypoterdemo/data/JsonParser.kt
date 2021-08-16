package com.nuruysal.harrypoterdemo.data

import android.content.Context
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by serifenuruysal on 8/1/21.
 */


@Singleton
open class JsonParser @Inject constructor(val context: Context) {

    /**
     * it loads byte stream from local json and return String type data
     */
    fun loadJSONFromAsset(): String? {

        return try {
            val input: InputStream = context.assets.open("products.json")
            val size: Int = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
    }
}
