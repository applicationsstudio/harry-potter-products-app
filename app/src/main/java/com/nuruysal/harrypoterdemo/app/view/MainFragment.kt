package com.nuruysal.harrypoterdemo.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nuruysal.harrypoterdemo.R
import com.nuruysal.harrypoterdemo.app.SpacingItemDecorator
import com.nuruysal.harrypoterdemo.app.adapter.OnItemActionListener
import com.nuruysal.harrypoterdemo.app.adapter.ProductsRecycleAdapter
import com.nuruysal.harrypoterdemo.app.viewmodel.MainViewModel
import com.nuruysal.harrypoterdemo.app.viewmodel.MainViewState
import com.nuruysal.harrypoterdemo.app.viewmodel.RowItemViewModel
import com.nuruysal.harrypoterdemo.base.BaseEvent
import com.nuruysal.harrypoterdemo.base.BaseFragment
import com.nuruysal.harrypoterdemo.databinding.FragmentListBinding
import com.nuruysal.harrypoterdemo.extensions.observe
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * Created by serifenuruysal on 8/1/21.
 */

@AndroidEntryPoint
class MainFragment : BaseFragment<MainViewState>() {

    val viewModel: MainViewModel by activityViewModels()

    @Inject
    lateinit var itemListAdapter: ProductsRecycleAdapter

    private lateinit var viewBinding: FragmentListBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        //setting ui binding lifecyleOwner
        viewBinding.lifecycleOwner = viewLifecycleOwner
        //Databinding from ui to viewmodel
        viewBinding.viewModel = viewModel
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //list adapter configurations
        viewBinding.rvFragmentItemList.adapter = itemListAdapter
        val x = (resources.displayMetrics.density * 4).toInt() //converting dp to pixels
        viewBinding.rvFragmentItemList.addItemDecoration(SpacingItemDecorator(x)) //setting space between items in RecyclerView

        //subscription for any data changes or view state changes
        observe(viewModel.state, ::onViewStateChange)
        //subscription for Events from viewModel
        observe(viewModel.event, ::onViewEventChange)

    }

    override fun onViewStateChange(viewMainViewState: MainViewState) {
        when (viewMainViewState) {
            is MainViewState.ProductListLoaded -> {
                viewMainViewState.productList?.let {
                    itemListAdapter.setList(
                        it,
                        onItemActionListener = object : OnItemActionListener {
                            override fun onItemClicked(item: RowItemViewModel) {
                                viewModel.setSelectedProduct(item)
                                findNavController().navigate(R.id.action_itemsListFragment_to_itemDetailFragment)
                            }

                        })
                }
            }
            is MainViewState.Error -> {
                //TODO show error dialog
            }
            is MainViewState.Loading -> {
                //TODO show progress dialog or loading
            }

        }
    }

    /**
     * Nothing to do for now.
     * it can be implemented if we need one way communication from viewModel to View */
    override fun onViewEventChange(viewEvent: BaseEvent) {
     //TODO
    }
}

