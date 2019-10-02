package com.devdream.cookall.signup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View

import com.devdream.cookall.R
import com.devdream.cookall.login.LoginActivity

class SignUpActivityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }

    fun signUp(view: View) {}

    fun navigateLogin(view: View) {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

}
