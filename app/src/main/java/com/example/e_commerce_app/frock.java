package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class frock extends AppCompatActivity {

    ImageView frockImage1, frockImage2, frockImage3, frockImage4, homeIcon, cartIcon, profileIcon, backIcon;
    TextView frockPrice1, frockPrice2, frockPrice3, frockPrice4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frock);

        frockImage1 = findViewById(R.id.frockImage1);
        frockImage2 = findViewById(R.id.frockImage2);
        frockImage3 = findViewById(R.id.frockImage3);
        frockImage4 = findViewById(R.id.frockImage4);
        homeIcon = findViewById(R.id.frockHomeIcon);
        cartIcon = findViewById(R.id.frockCartIcon);
        profileIcon = findViewById(R.id.frockProfileIcon);
        backIcon = findViewById(R.id.frockBackIcon);
        frockPrice1 = findViewById(R.id.frockPrice1);
        frockPrice2 = findViewById(R.id.frockPrice2);
        frockPrice3 = findViewById(R.id.frockPrice3);
        frockPrice4 = findViewById(R.id.frockPrice4);

        final ArrayList<String> frockList = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("products");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    if (((HashMap)(dataSnapshot.getValue())).get("category") == "Frocks") {
                        frockList.add(dataSnapshot.getValue().toString());
                    }
                }

                for(int i=0; i<frockList.size(); i++) {

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.e_commerce_app.home.class);
                startActivity(intent);
            }
        });

        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.e_commerce_app.cart.class);
                startActivity(intent);
            }
        });

        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.e_commerce_app.profile.class);
                startActivity(intent);
            }
        });





    }
}