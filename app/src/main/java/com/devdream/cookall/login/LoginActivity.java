package com.devdream.cookall.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.devdream.cookall.R;
import com.devdream.cookall.main.MainActivity;
import com.devdream.cookall.signup.SignUpActivityActivity;

public class LoginActivity extends AppCompatActivity implements LoginListener {

    protected ProgressBar loadingProgressBar;
    protected Button loginButton;

    private EditText email;
    private EditText password;
    private TextView errorMessage;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.email_editText);
        password = (EditText) findViewById(R.id.password_editText);
        errorMessage = (TextView) findViewById(R.id.error_message);
        loadingProgressBar = (ProgressBar) findViewById(R.id.loading_progress_bar);
        loginButton = (Button) findViewById(R.id.login_button);

        loginPresenter = new LoginPresenter(this);
    }

    public void login(View view) {
        loginPresenter.login(email.getText().toString(), password.getText().toString());
    }

    public void showLoginError() {
        errorMessage.setVisibility(View.VISIBLE);
    }

    public void navigateHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void navigateSignUp(View view) {
        startActivity(new Intent(this, SignUpActivityActivity.class));
        finish();
    }

}
