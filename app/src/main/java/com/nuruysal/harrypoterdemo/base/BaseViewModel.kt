package com.nuruysal.harrypoterdemo.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nuruysal.harrypoterdemo.extensions.SingleLiveData

/**
 * Created by serifenuruysal on 8/1/21 .
 */

abstract class BaseViewModel<ViewState : BaseViewState> :
    ViewModel() {
    protected val uiState = MutableLiveData<ViewState>()
    val state: LiveData<ViewState>
        get() = uiState

    protected val uiEvent = SingleLiveData<BaseEvent>()
    val event: LiveData<BaseEvent>
        get() = uiEvent

}

