package com.devdream.cookall.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.devdream.cookall.R;

/**
 * Generic ViewHolder for main fragments recipe lists.
 *
 * All lists on main have the same list item structure component, so it is safe to bind the
 * components to this view holder.
 */
public class RecipeViewHolder extends RecyclerView.ViewHolder {

    public final View mView;
    public final TextView mContentView;

    // TODO Set here RecipeDTO

    public RecipeViewHolder(View view) {
        super(view);
        mView = view;
        // Component binding
        mContentView = (TextView) view.findViewById(R.id.recipe_name);
    }

}
