package com.devdream.cookall.main.explore

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.devdream.cookall.R
import com.devdream.cookall.core.dto.RecipeDTO
import com.devdream.cookall.main.RecipeViewHolder

class ExploreRecipesRecyclerViewAdapter(private val recipes: List<RecipeDTO>,
                                        private val mListener: ExploreRecipesFragment.OnListFragmentInteractionListener?) : RecyclerView.Adapter<RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_recipe_list_item, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RecipeViewHolder, position: Int) {
        viewHolder.recipe = recipes[position]

        viewHolder.titleTextView.text = viewHolder.recipe!!.title

        viewHolder.view.setOnClickListener {
            mListener?.onListFragmentInteraction(viewHolder.recipe)
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

}
