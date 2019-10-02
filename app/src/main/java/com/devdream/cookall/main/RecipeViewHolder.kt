package com.devdream.cookall.main

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.TextView

import com.devdream.cookall.R
import com.devdream.cookall.core.dto.RecipeDTO

/**
 * Generic ViewHolder for main fragments recipe lists.
 *
 * All lists on main have the same list item structure component, so it is safe to bind the
 * components to this view holder.
 */
class RecipeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var recipe: RecipeDTO? = null

    val titleTextView: TextView

    init {
        // Component binding
        titleTextView = view.findViewById<View>(R.id.recipe_title) as TextView
    }

}
