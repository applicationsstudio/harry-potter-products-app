package com.nuruysal.harrypoterdemo.extensions

/**
 * Created by serifenuruysal on 8/1/21.
 */

fun <T> lazyN(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)