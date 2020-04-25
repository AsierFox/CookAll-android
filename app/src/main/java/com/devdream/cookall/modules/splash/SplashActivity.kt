package com.devdream.cookall.modules.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devdream.cookall.modules.auth.AuthActivity
import com.example.cookall.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }

}
