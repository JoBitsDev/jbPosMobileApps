package com.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.controllers.LoginController;
import com.utils.exception.ExceptionHandler;


public class LoginActivity extends BaseActivity {

    private LoginController controller;

    private TextView loginResult;
    private Button loginButton;
    private EditText user;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initVarialbes();
        addListeners();
    }

    @Override
    protected void initVarialbes() {
        controller = new LoginController();

        loginResult = (TextView) findViewById(R.id.loginResult);
        loginButton = (Button) findViewById(R.id.loginButton);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
    }

    @Override
    protected void addListeners() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginButtonOnClick(v);
            }
        });
    }

    private void onLoginButtonOnClick(View v) {
        autenticar(v);
    }

    private void autenticar(View v) {
        String username = user.getText().toString();
        String password = pass.getText().toString();

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            loginResult.setTextColor(Color.RED);
            loginResult.setText(R.string.errorAlAutenticar);
        } else {
            try {
                if (controller.loginAction(username, password)) {
                    loginResult.setTextColor(Color.GREEN);
                    loginResult.setText(R.string.autenticacionCorrecta);

                    Intent launch = new Intent(this, PantallaPrincipalActivity.class);
                    launch.putExtra(String.valueOf(R.string.user), username);
                    startActivity(launch);
                } else {
                    loginResult.setTextColor(Color.RED);
                    loginResult.setText(R.string.errorAlAutenticar);
                }
            } catch (Exception e) {
                ExceptionHandler.handleException(e, this);
            }

        }

    }

}
