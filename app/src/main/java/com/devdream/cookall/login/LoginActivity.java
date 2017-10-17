package com.devdream.cookall.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.devdream.cookall.R;
import com.devdream.cookall.main.MainActivity;
import com.devdream.cookall.signup.SignUpActivityActivity;

public class LoginActivity extends AppCompatActivity implements LoginListener {

    private ProgressBar loadingProgressBar;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loadingProgressBar = (ProgressBar) findViewById(R.id.login_progress);

        loginPresenter = new LoginPresenter(this);
    }

    public void login(View view) {
        loadingProgressBar.setVisibility(View.VISIBLE);

        //loadingProgressBar.setVisibility(View.GONE);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void navigateSignUp(View view) {
        startActivity(new Intent(this, SignUpActivityActivity.class));
        finish();
    }

}
