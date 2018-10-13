package com.example.alvindrakes.doubleparkingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class StartPage extends AppCompatActivity {

    Button signUpBtn;
    Button logInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

         logInBtn = (Button) findViewById(R.id.Log_in);
    }
}
