package com.devdream.cookall.main.explore;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devdream.cookall.R;
import com.devdream.cookall.core.dto.RecipeDTO;

import java.util.List;

public class ExploreRecipesFragment extends Fragment implements ExploreRecipesListener {

    public static final String TAG = "com.devdream.cookall.main.explore.ExploreRecipesFragment";

    private OnListFragmentInteractionListener mListener;
    private ExploreRecipesPresenter exploreRecipesPresenter;

    private RecyclerView recyclerView;

    public ExploreRecipesFragment() {
        exploreRecipesPresenter = new ExploreRecipesPresenter(this);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ExploreRecipesFragment.
     */
    public static ExploreRecipesFragment newInstance() {
        ExploreRecipesFragment fragment = new ExploreRecipesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Receive here the arguments
//        if (getArguments() != null) {
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore_recipes_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            exploreRecipesPresenter.getAllRecipes();
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void recipesLoaded(List<RecipeDTO> recipes) {
        recyclerView.setAdapter(new ExploreRecipesRecyclerViewAdapter(recipes, mListener));
    }

    public interface OnListFragmentInteractionListener {

        void onListFragmentInteraction(RecipeDTO item);

    }

}
