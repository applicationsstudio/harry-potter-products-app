package com.nuruysal.harrypoterdemo.base

/**
 * Created by serifenuruysal on 8/1/21.
 */
sealed class BaseResult<T>(
    val data: T? = null,
    val errorResponse: Throwable? = null
) {
    class Success<T>(data: T? = null) : BaseResult<T>(data)
    class Loading<T>(data: T? = null) : BaseResult<T>(data)
    class Error<T>(errorResponse: Throwable, data: T? = null) : BaseResult<T>(data, errorResponse)

    fun isLoading() = this is Loading
    fun isSuccess() = this is Success
    fun isError() = this is Error
}