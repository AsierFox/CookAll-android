package com.devdream.cookall.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.devdream.cookall.R;
import com.devdream.cookall.main.MainActivity;
import com.devdream.cookall.signup.SignUpActivityActivity;

public class LoginActivity extends AppCompatActivity implements LoginListener {

    private ProgressBar loadingProgressBar;
    private Button loginButton;
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

    public void navigateHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void navigateSignUp(View view) {
        startActivity(new Intent(this, SignUpActivityActivity.class));
        finish();
    }

    private void enableLogin() {
        errorMessage.setVisibility(View.GONE);
        loadingProgressBar.setVisibility(View.VISIBLE);
        loginButton.setEnabled(false);
    }

    private void disableLogin() {
        loadingProgressBar.setVisibility(View.GONE);
        loginButton.setEnabled(true);
    }

    @Override
    public void startLoginProcess() {
        boolean skipLogin = true;
        if (skipLogin) {
            navigateHome();
        } else {
            enableLogin();
        }
    }

    @Override
    public void successLoginProcess() {
        navigateHome();
    }

    @Override
    public void errorLoginProcess() {
        errorMessage.setVisibility(View.VISIBLE);
        disableLogin();
    }

    @Override
    public void noNetworkAccessError() {
        disableLogin();
        Toast.makeText(this, "You don't have internet connection!", Toast.LENGTH_SHORT).show();
    }

}
