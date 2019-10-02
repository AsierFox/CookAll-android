package com.devdream.cookall.main.explore;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devdream.cookall.R;
import com.devdream.cookall.core.dto.RecipeDTO;
import com.devdream.cookall.main.RecipeViewHolder;

import java.util.List;

public class ExploreRecipesRecyclerViewAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private final List<RecipeDTO> recipes;
    private final ExploreRecipesFragment.OnListFragmentInteractionListener mListener;

    public ExploreRecipesRecyclerViewAdapter(List<RecipeDTO> _recipes,
                                             ExploreRecipesFragment.OnListFragmentInteractionListener listener) {
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
    public void onBindViewHolder(final RecipeViewHolder viewHolder, int position) {
        viewHolder.recipe = recipes.get(position);

        viewHolder.titleTextView.setText(viewHolder.recipe.title);

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(viewHolder.recipe);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

}
