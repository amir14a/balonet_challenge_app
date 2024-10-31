package com.aaj.balonetchallengeapplication.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView

class GlobalAdapter<T, T2 : ViewDataBinding>(
    @LayoutRes
    private val resId: Int,
    private var items: List<T>,
    private val moreBindings: ((position: Int, T2) -> Unit)? = null,
    private val clickInterface: ((T) -> Unit)? = null,
) : RecyclerView.Adapter<GlobalAdapter<T, T2>.GlobalAdapterViewHolder>() {

    inner class GlobalAdapterViewHolder(val binding: T2) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: T, position: Int) {
            binding.setVariable(BR.item, item)
            moreBindings?.let { moreBindings.invoke(position, binding) }
            binding.executePendingBindings()
        }
    }

    override fun getItemViewType(position: Int): Int = position
    override fun getItemId(position: Int): Long = position.toLong()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GlobalAdapterViewHolder {
        val binding =
            DataBindingUtil.inflate<T2>(LayoutInflater.from(parent.context), resId, parent, false)
        return GlobalAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: GlobalAdapterViewHolder, position: Int) {
        holder.bind(items[position], position)
        holder.binding.root.setOnClickListener {
            clickInterface?.invoke(items[position])
        }
    }
}
