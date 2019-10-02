package com.devdream.cookall.main.favorites;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devdream.cookall.R;
import com.devdream.cookall.core.dto.RecipeDTO;
import com.devdream.cookall.main.RecipeViewHolder;

import java.util.List;

public class FavoriteRecipesRecyclerViewAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private final List<RecipeDTO> recipes;
    private final FavoriteRecipesFragment.OnListFragmentInteractionListener mListener;

    public FavoriteRecipesRecyclerViewAdapter(List<RecipeDTO> _recipes,
                                              FavoriteRecipesFragment.OnListFragmentInteractionListener listener) {
        recipes = _recipes;
        mListener = listener;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_recipe_list_item, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecipeViewHolder holder, int position) {
        holder.recipe = recipes.get(position);

        holder.titleTextView.setText(recipes.get(position).title);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.recipe);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

}
