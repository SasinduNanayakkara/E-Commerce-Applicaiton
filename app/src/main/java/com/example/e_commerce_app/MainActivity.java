package com.example.e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView textMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        textMsg = findViewById(R.id.textMsg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), sample.class);
                startActivity(intent);
            }
        });

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Sasindu");
        map.put("email", "sasindu@gmail.com");

        FirebaseDatabase.getInstance().getReference().child("programming").child("hash-map").updateChildren(map);
    }
}