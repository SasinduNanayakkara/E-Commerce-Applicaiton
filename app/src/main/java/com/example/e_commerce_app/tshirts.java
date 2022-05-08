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

public class tshirts extends AppCompatActivity {
    ImageView tShirt1, tShirt2, tShirt3, tShirt4, home, cart, profile, back;
    TextView tShirtPrice1, tShirtPrice2, tShirtPrice3, tShirtPrice4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tshirts);

        tShirt1 = findViewById(R.id.tShirtImage1);
        tShirt2 = findViewById(R.id.tShirtImage2);
        tShirt3 = findViewById(R.id.tShirtImage3);
        tShirt4 = findViewById(R.id.tShirtImage4);
        home = findViewById(R.id.tShirtHomeIcon);
        cart = findViewById(R.id.tShirtCartImage);
        profile = findViewById(R.id.tShirtProfileImage);
        back = findViewById(R.id.tShirtBackIcon);
        tShirtPrice1 = findViewById(R.id.tShirtPrice1);
        tShirtPrice2 = findViewById(R.id.tShirtPrice2);
        tShirtPrice3 = findViewById(R.id.tShirtPrice3);
        tShirtPrice4 = findViewById(R.id.tShirtPrice4);

        final ArrayList<String> tShirtList = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("products");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    if (((HashMap)(dataSnapshot.getValue())).get("category") == "Tshirt") {
                        tShirtList.add(dataSnapshot.getValue().toString());
                    }
                }

                for(int i=0; i<tShirtList.size(); i++) {

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.e_commerce_app.home.class);
                startActivity(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.e_commerce_app.cart.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.e_commerce_app.profile.class);
                startActivity(intent);
            }
        });


    }
}