package com.aaj.balonetchallengeapplication.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aaj.balonetchallengeapplication.databinding.CategoryItemBinding
import com.aaj.balonetchallengeapplication.model.CategoryModel

class CategoriesAdapter(
    private var items: List<CategoryModel>,
    private val clickInterface: CategoryClickInterface,
) : RecyclerView.Adapter<CategoriesAdapter.CategoriesAdapterViewHolder>() {

    inner class CategoriesAdapterViewHolder(val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryModel) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapterViewHolder {
        val binding =
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CategoriesAdapterViewHolder, position: Int) {
        holder.bind(items[position])
        holder.binding.mainCard.setOnClickListener {
            clickInterface.onClick(items[position])
        }
    }
}

fun interface CategoryClickInterface {
    fun onClick(categoryModel: CategoryModel)
}