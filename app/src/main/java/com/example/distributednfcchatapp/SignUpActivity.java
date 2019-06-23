package com.example.distributednfcchatapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {

    private Button signUpButton;
    private EditText userName;
    private EditText userEmail;
    private EditText userPassword;
    private Intent intent;

    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpButton = (Button) findViewById(R.id._signUpButton);
        userName = (EditText) findViewById(R.id._userNameText);
        userEmail = (EditText) findViewById(R.id.emailText);
        userPassword = (EditText) findViewById(R.id._userPassword);

        auth = FirebaseAuth.getInstance();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewUser();

            }
        });
    }

    private void createNewUser() {
        if (!(userName.getText().toString().equals("")) && !(userEmail.getText().toString().equals("")) && !(userPassword.getText().toString().equals(""))) {
            auth.createUserWithEmailAndPassword(userEmail.getText().toString(), userPassword.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser firebaseUser = auth.getCurrentUser();
                                String userid =firebaseUser.getUid();

                                reference = FirebaseDatabase.getInstance().getReference("Users").child("userid");

                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("id", userid);
                                hashMap.put("username", userName.getText().toString());
                                hashMap.put("imageURL", "default");

                                reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            intent = new Intent(SignUpActivity.this, FrontPageActivity.class);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(SignUpActivity.this, "Invalid Username, Email or Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


        } else {

        }
    }

}
