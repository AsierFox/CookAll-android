package com.devdream.cookall.modules.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.cookall.R
import com.example.cookall.databinding.FragmentRecipeListMainMyRecipeBinding

class MyRecipeListFragment : Fragment() {

    private lateinit var dataBindingUtil: FragmentRecipeListMainMyRecipeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBindingUtil = DataBindingUtil.inflate(inflater, R.layout.fragment_recipe_list_main_my_recipe, container, false)

        return dataBindingUtil.root
    }

}
