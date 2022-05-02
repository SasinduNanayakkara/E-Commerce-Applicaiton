package com.example.e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class buy_now extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_buy_now);
    }
}