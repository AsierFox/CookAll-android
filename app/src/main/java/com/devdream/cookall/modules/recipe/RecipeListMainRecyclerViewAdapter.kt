package com.devdream.cookall.modules.recipe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devdream.cookall.common.dto.RecipeDTO
import com.example.cookall.R

class RecipeListMainRecyclerViewAdapter(
    private val recipeList: List<RecipeDTO>,
    private val mListener: RecipeListMainContract.OnListFragmentInteractionListener?
) : RecyclerView.Adapter<RecipeListMainRecyclerViewAdapter.RecipeViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as RecipeDTO
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_linear_list_item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe: RecipeDTO = recipeList[position]

        with(holder.itemView) {
            tag = recipe
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = recipeList.size

    inner class RecipeViewHolder(private val mView: View) : RecyclerView.ViewHolder(mView) {

        var recipe: RecipeDTO? = null

        override fun toString(): String {
            return super.toString() + " MEW "
        }
    }

}
