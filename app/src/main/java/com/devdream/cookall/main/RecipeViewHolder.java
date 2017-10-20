package com.devdream.cookall.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.devdream.cookall.R;
import com.devdream.cookall.core.dto.RecipeDTO;

/**
 * Generic ViewHolder for main fragments recipe lists.
 *
 * All lists on main have the same list item structure component, so it is safe to bind the
 * components to this view holder.
 */
public class RecipeViewHolder extends RecyclerView.ViewHolder {

    public final View view;

    public RecipeDTO recipe;

    public final TextView titleTextView;

    public RecipeViewHolder(View _view) {
        super(_view);
        view = _view;
        // Component binding
        titleTextView = (TextView) view.findViewById(R.id.recipe_title);
    }

}
