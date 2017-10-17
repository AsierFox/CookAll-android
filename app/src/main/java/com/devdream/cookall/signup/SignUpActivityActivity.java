package com.devdream.cookall.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.devdream.cookall.R;
import com.devdream.cookall.login.LoginActivity;

public class SignUpActivityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_activity);
    }

    public void signUp(View view) {
    }

    public void navigateLogin(View view) {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

}
