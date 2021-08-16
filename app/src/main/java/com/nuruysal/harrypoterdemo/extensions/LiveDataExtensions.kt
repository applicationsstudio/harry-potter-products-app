package com.nuruysal.harrypoterdemo.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

/**
 * Created by serifenuruysal on 8/1/21.
 */


fun <T> LifecycleOwner.observe(liveData: LiveData<T>, observer: (T) -> Unit) {
    liveData.observe(this, {
        it?.let { t -> observer(t) }
    })
}

