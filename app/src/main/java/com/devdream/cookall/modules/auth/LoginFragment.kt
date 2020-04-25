package com.devdream.cookall.modules.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.devdream.cookall.modules.recipe.RecipeListMainActivity
import com.example.cookall.R
import com.example.cookall.databinding.FragmentAuthLoginBinding
import kotlinx.android.synthetic.main.fragment_auth_login.view.*

class LoginFragment : Fragment(), AuthContract.LoginView {

    private lateinit var dataBindingUtil: FragmentAuthLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBindingUtil = DataBindingUtil.inflate(inflater, R.layout.fragment_auth_login, container, false)

        return dataBindingUtil.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.login_button.setOnClickListener { v -> loginOnClick(v)}

        view.link_signup.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

   override fun loginOnClick(view: View) {
       val intent = Intent(activity, RecipeListMainActivity::class.java)
       activity?.startActivity(intent)
       activity?.finish()
    }

}
