package com.devdream.cookall.main.favorites

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.devdream.cookall.R
import com.devdream.cookall.core.dto.RecipeDTO
import com.devdream.cookall.main.RecipeViewHolder

class FavoriteRecipesRecyclerViewAdapter(private val recipes: List<RecipeDTO>,
                                         private val mListener: FavoriteRecipesFragment.OnListFragmentInteractionListener?) : RecyclerView.Adapter<RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_recipe_list_item, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.recipe = recipes[position]

        holder.titleTextView.text = recipes[position].title

        holder.view.setOnClickListener {
            mListener?.onListFragmentInteraction(holder.recipe as RecipeDTO)
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

}
