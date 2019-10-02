package com.devdream.cookall.main.explore

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.devdream.cookall.R
import com.devdream.cookall.core.dto.RecipeDTO

class ExploreRecipesFragment : Fragment(), ExploreRecipesListener {

    private var mListener: OnListFragmentInteractionListener? = null
    private val exploreRecipesPresenter: ExploreRecipesPresenter

    private var recyclerView: RecyclerView? = null

    init {
        exploreRecipesPresenter = ExploreRecipesPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Receive here the arguments
        //        if (getArguments() != null) {
        //        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_explore_recipes_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()
            recyclerView = view

            recyclerView!!.layoutManager = LinearLayoutManager(context)

            exploreRecipesPresenter.getAllRecipes()
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    override fun recipesLoaded(recipes: List<RecipeDTO>) {
        recyclerView!!.adapter = ExploreRecipesRecyclerViewAdapter(recipes, mListener)
    }

    interface OnListFragmentInteractionListener {

        fun onListFragmentInteraction(item: RecipeDTO)

    }

    companion object {

        val TAG = "com.devdream.cookall.main.explore.ExploreRecipesFragment"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ExploreRecipesFragment.
         */
        fun newInstance(): ExploreRecipesFragment {
            val fragment = ExploreRecipesFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}
