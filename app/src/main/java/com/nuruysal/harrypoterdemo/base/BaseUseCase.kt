package com.nuruysal.harrypoterdemo.base

/**
 * Created by serifenuruysal on 8/1/21.
 */
interface BaseUseCase<T> {

    fun execute(): BaseResult<T>
}
