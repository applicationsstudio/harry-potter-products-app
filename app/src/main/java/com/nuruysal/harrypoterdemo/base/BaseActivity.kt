package com.nuruysal.harrypoterdemo.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

/**
 * Created by serifenuruysal on 8/1/21
 */
abstract class BaseActivity(
    @LayoutRes
    private val layoutId: Int
) : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }


    override fun onDestroy() {
        Timber.d("onDestroy")
        super.onDestroy()
    }


    override fun onResume() {
        super.onResume()

        Timber.d("onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("onPause")
    }

    override fun onStop() {

        super.onStop()
        Timber.d("onStop")
    }
}
