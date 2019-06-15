package com.example.distributednfcchatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class FrontPageActivity extends AppCompatActivity {

    private CircleImageView profilePicture;
    private TextView userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page_acitivity);

        profilePicture = (CircleImageView) findViewById(R.id.profile_picture);
        userName = (TextView) findViewById(R.id.usernameBar);
    }
}
