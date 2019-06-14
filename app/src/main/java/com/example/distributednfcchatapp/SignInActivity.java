package com.example.distributednfcchatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {
    private EditText userName;
    private EditText password;
    private Button loginButton;
    private Button signUpButton;
    private Button forgotPasswordButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        userName = (EditText) findViewById(R.id._userNameText);
        password = (EditText) findViewById(R.id.emailText);
        loginButton = (Button) findViewById(R.id.signInButton);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        forgotPasswordButton = (Button) findViewById(R.id.forgotPasswordButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(userName.getText().toString(), password.getText().toString());
            }
        });


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });


    }

    private void validate(String _userName, String _userPassword) {
        if ((_userName.equals("User")) && (_userPassword.equals("Password"))) {
            Intent intent = new Intent(SignInActivity.this, FrontPageActivity.class);
            startActivity(intent);
        } else {

        }
    }

    private void signUp() {
        Intent signUpIntent = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(signUpIntent);
    }
}
