package com.devdream.cookall.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.devdream.cookall.R;
import com.devdream.cookall.core.db.RealmInitializer;
import com.devdream.cookall.login.LoginActivity;

import io.realm.Realm;

public class SplashActivity extends AppCompatActivity {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        RealmInitializer.init();

        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

}
