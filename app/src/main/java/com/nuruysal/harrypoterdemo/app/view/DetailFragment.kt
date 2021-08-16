package com.nuruysal.harrypoterdemo.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.nuruysal.harrypoterdemo.R
import com.nuruysal.harrypoterdemo.app.viewmodel.MainViewModel
import com.nuruysal.harrypoterdemo.app.viewmodel.MainViewState
import com.nuruysal.harrypoterdemo.base.BaseEvent
import com.nuruysal.harrypoterdemo.base.BaseFragment
import com.nuruysal.harrypoterdemo.databinding.FragmentDetailBinding
import com.nuruysal.harrypoterdemo.extensions.observe

/**
 * Created by serifenuruysal on 8/1/21.
 */
class DetailFragment : BaseFragment<MainViewState>() {

    val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //subscription for any data changes or view state changes
        observe(viewModel.state, ::onViewStateChange)
        //subscription for Events from viewModel
        observe(viewModel.event, ::onViewEventChange)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail, container, false
        )
        //setting ui binding lifecyleOwner
        binding.lifecycleOwner = viewLifecycleOwner

        //Databinding from ui to viewmodel
        binding.viewModel = viewModel
        return binding.root
    }

    /**
     * Nothing to do for now.it can be implemented if we need to do any data changes or view state changes.
     * One way communication from viewModel to View
     */
    override fun onViewStateChange(viewMainViewState: MainViewState) {
        //TODO
    }

    /**
     * Nothing to do for now.
     * it can be implemented if we need one way communication from viewModel to View
     */
    override fun onViewEventChange(viewEvent: BaseEvent) {
        //TODO

    }
}