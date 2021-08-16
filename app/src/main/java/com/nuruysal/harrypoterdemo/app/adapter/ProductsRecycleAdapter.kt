package com.nuruysal.harrypoterdemo.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nuruysal.harrypoterdemo.app.viewmodel.RowItemViewModel
import com.nuruysal.harrypoterdemo.databinding.LayoutRowListItemBinding
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by serifenuruysal on 8/1/21.
 */
class ProductsRecycleAdapter @Inject constructor() :
    RecyclerView.Adapter<ProductsRecycleAdapter.ViewHolder>() {
    private var items: List<RowItemViewModel> = arrayListOf()
    private var onItemActionListener: OnItemActionListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Timber.d("onCreateViewHolder")

        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutRowListItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    fun setList(newItems: List<RowItemViewModel>, onItemActionListener: OnItemActionListener?) {

        val diffCallback = DiffCallback(this.items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this)
        this.items = newItems
        this.onItemActionListener = onItemActionListener
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(private val binding: LayoutRowListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RowItemViewModel) {
            binding.model = item
            binding.root.setOnClickListener {
                onItemActionListener?.onItemClicked(item)
            }
        }
    }
}

//DiffUtil is a utility class that can calculate the difference between two lists and
// output a list of update operations that converts the first list into the second one.

//It can be used to calculate updates for a RecyclerView Adapter.

open class DiffCallback(
    private val oldGalaxies: List<RowItemViewModel>,
    private val newGalaxies: List<RowItemViewModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldGalaxies.size
    }

    override fun getNewListSize(): Int {
        return newGalaxies.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // In the real world you need to compare something unique like id
        return oldGalaxies[oldItemPosition].title == newGalaxies[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // This is called if areItemsTheSame() == true;
        return oldGalaxies[oldItemPosition] == newGalaxies[newItemPosition]
    }
}

interface OnItemActionListener {
    fun onItemClicked(item: RowItemViewModel)
}

