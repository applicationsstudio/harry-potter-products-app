package com.nuruysal.harrypoterdemo.app.adapter

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.nuruysal.harrypoterdemo.R
import com.squareup.picasso.Picasso
import timber.log.Timber

/**
 * Created by serifenuruysal on 8/1/21.
 */

object DataBindingAdapters {

    @JvmStatic
    @BindingAdapter("glide")
    fun glide(image: ImageView, imageUrl: String?) {
        Timber.d("url:$imageUrl")
//        if (imageUrl.isNullOrEmpty().not()) {

            Picasso.with(image.context).load(Uri.decode(imageUrl))
                .error(R.drawable.no_image)
                .into(image)
//        }

    }

}





