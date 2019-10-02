package com.devdream.cookall.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.devdream.cookall.R
import com.devdream.cookall.core.realm.RealmInitializer
import com.devdream.cookall.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        RealmInitializer.init()

        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

}
