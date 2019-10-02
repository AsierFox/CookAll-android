package com.devdream.cookall.main.favorites

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
import com.devdream.cookall.main.DummyListContent

/**
 * A fragment representing a list of Items.
 *
 *
 * Activities containing this fragment MUST implement the [OnListFragmentInteractionListener]
 * interface.
 */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class FavoriteRecipesFragment : Fragment() {

    private var mListener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get arguments
        //        if (getArguments() != null) {
        //            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        //        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_favorite_recipes_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()

            view.layoutManager = LinearLayoutManager(context)

            view.adapter = FavoriteRecipesRecyclerViewAdapter(DummyListContent.ITEMS, mListener)
        }
        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnListFragmentInteractionListener {

        fun onListFragmentInteraction(item: RecipeDTO)

    }

    companion object {

        val TAG = "com.devdream.cookall.main.favoriterecipes.FavoriteRecipesFragment"

        // TODO: Customize parameter argument names
        private val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        fun newInstance(columnCount: Int): FavoriteRecipesFragment {
            val fragment = FavoriteRecipesFragment()
            val args = Bundle()
            args.putInt(ARG_COLUMN_COUNT, columnCount)
            fragment.arguments = args
            return fragment
        }
    }

}
