package com.devdream.cookall.modules.recipe

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devdream.cookall.common.dto.RecipeDTO
import com.example.cookall.R
import com.example.cookall.databinding.FragmentRecipeListMainFavoriteBinding

class FavoriteRecipeListFragment : Fragment() {

    private val TAG: String = "FavoriteRecipeListFragment"

    private lateinit var dataBindingUtil: FragmentRecipeListMainFavoriteBinding

    private lateinit var recyclerView: RecyclerView

    private var recipeListListener: RecipeListMainContract.OnListFragmentInteractionListener? = null
    private lateinit var recipeList: ArrayList<RecipeDTO>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipeList =  ArrayList<RecipeDTO>()
        recipeList.add(RecipeDTO())
        recipeList.add(RecipeDTO())
        recipeList.add(RecipeDTO())
        recipeList.add(RecipeDTO())
        recipeList.add(RecipeDTO())
        recipeList.add(RecipeDTO())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBindingUtil = DataBindingUtil.inflate(inflater, R.layout.fragment_recipe_list_main_favorite, container, false)

        recyclerView = dataBindingUtil.root as RecyclerView

        // Set the adapter
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = RecipeListMainRecyclerViewAdapter(recipeList, recipeListListener)
        }

        return dataBindingUtil.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is RecipeListMainContract.OnListFragmentInteractionListener) {
            recipeListListener = context
        }
        else {
            Log.e(TAG, "$context does not implement RecipeListMainContract.OnListFragmentInteractionListener!")
        }
    }

    override fun onDetach() {
        super.onDetach()
        recipeListListener = null
    }

//    companion object {
//
//        // TODO: Customize parameter argument names
//        const val ARG_COLUMN_COUNT = "column-count"
//
//        // TODO: Customize parameter initialization
//        @JvmStatic
//        fun newInstance(columnCount: Int) =
//            ItemFragment().apply {
//                arguments = Bundle().apply {
//                    putInt(ARG_COLUMN_COUNT, columnCount)
//                }
//            }
//    }

}
