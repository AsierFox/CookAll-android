package com.devdream.cookall.splash;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.devdream.cookall.R;
import com.devdream.cookall.core.realm.RealmInitializer;
import com.devdream.cookall.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        RealmInitializer.init();

        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

}
