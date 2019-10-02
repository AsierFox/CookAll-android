package com.devdream.cookall.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

import com.devdream.cookall.R
import com.devdream.cookall.main.MainActivity
import com.devdream.cookall.signup.SignUpActivityActivity

class LoginActivity : AppCompatActivity(), LoginListener {

    private var loadingProgressBar: ProgressBar? = null
    private var loginButton: Button? = null
    private var email: EditText? = null
    private var password: EditText? = null
    private var errorMessage: TextView? = null
    private var loginPresenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById<View>(R.id.email_editText) as EditText
        password = findViewById<View>(R.id.password_editText) as EditText
        errorMessage = findViewById<View>(R.id.error_message) as TextView
        loadingProgressBar = findViewById<View>(R.id.loading_progress_bar) as ProgressBar
        loginButton = findViewById<View>(R.id.login_button) as Button

        loginPresenter = LoginPresenter(this)
    }

    fun login(view: View) {
        loginPresenter!!.login(email!!.text.toString(), password!!.text.toString())
    }

    fun navigateHome() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun navigateSignUp(view: View) {
        startActivity(Intent(this, SignUpActivityActivity::class.java))
        finish()
    }

    private fun enableLogin() {
        errorMessage!!.visibility = View.GONE
        loadingProgressBar!!.visibility = View.VISIBLE
        loginButton!!.isEnabled = false
    }

    private fun disableLogin() {
        loadingProgressBar!!.visibility = View.GONE
        loginButton!!.isEnabled = true
    }

    override fun startLoginProcess() {
        val skipLogin = true
        if (skipLogin) {
            navigateHome()
        } else {
            enableLogin()
        }
    }

    override fun successLoginProcess() {
        navigateHome()
    }

    override fun errorLoginProcess() {
        errorMessage!!.visibility = View.VISIBLE
        disableLogin()
    }

    override fun noNetworkAccessError() {
        disableLogin()
        Toast.makeText(this, "You don't have internet connection!", Toast.LENGTH_SHORT).show()
    }

}
