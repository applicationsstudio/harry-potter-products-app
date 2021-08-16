package com.nuruysal.harrypoterdemo.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import com.nuruysal.harrypoterdemo.app.viewmodel.MainViewState

/**
 * Created by serifenuruysal on 8/1/21
 */
abstract class BaseFragment<S : BaseViewState> : Fragment(), LifecycleObserver {

    /**
     * it can be implemented if we need to do any data changes or view state changes.
     * One way communication from viewModel to View
     */
    abstract fun onViewStateChange(viewMainViewState: S)

    /**
     *
     * it can be implemented if we need one way communication from viewModel to View
     */
    abstract fun onViewEventChange(viewEvent: BaseEvent)

    /**
     * Subscription for being lifecycleOwner
     */
    fun addLifecycleObserver(lifecycleObserver: LifecycleObserver) {
        lifecycle.addObserver(lifecycleObserver)
    }
}