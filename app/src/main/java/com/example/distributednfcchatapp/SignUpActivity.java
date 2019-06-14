package com.example.distributednfcchatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    private Button signUpButton;
    private EditText userName;
    private EditText userEmail;
    private EditText userPassword;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpButton = (Button) findViewById(R.id._signUpButton);
        userName = (EditText) findViewById(R.id._userNameText);
        userEmail = (EditText) findViewById(R.id.emailText);
        userPassword = (EditText) findViewById(R.id._userPassword);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewUser();

            }
        });
    }

    private void createNewUser() {

        if (!(userName.getText().toString().equals("")) && !(userEmail.getText().toString().equals("")) && !(userPassword.getText().toString().equals(""))) {

            intent = new Intent(SignUpActivity.this, FrontPageActivity.class);
            startActivity(intent);
        } else {

        }
    }

}
