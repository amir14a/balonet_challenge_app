package com.aaj.balonetchallengeapplication.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aaj.balonetchallengeapplication.databinding.RecipeItemBinding
import com.aaj.balonetchallengeapplication.model.RecipeModel

class RecipesAdapter(
    private var items: List<RecipeModel>,
    private val clickInterface: RecipeClickInterface,
) : RecyclerView.Adapter<RecipesAdapter.RecipesAdapterViewHolder>() {

    inner class RecipesAdapterViewHolder(val binding: RecipeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecipeModel) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun getItemViewType(position: Int): Int = position
    override fun getItemId(position: Int): Long = position.toLong()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesAdapterViewHolder {
        val binding =
            RecipeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipesAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecipesAdapterViewHolder, position: Int) {
        holder.bind(items[position])
        holder.binding.mainCard.setOnClickListener {
            clickInterface.onClick(items[position])
        }
    }
}

fun interface RecipeClickInterface {
    fun onClick(categoryModel: RecipeModel)
}