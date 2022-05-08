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

public class bags extends AppCompatActivity {

    ImageView bagImage1, bagImage2, bagImage3, bagImage4, home, back, cart, profile;
    TextView bagPrice1, bagPrice2, bagPrice3, bagPrice4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bags);

        bagImage1 = findViewById(R.id.bagImage1);
        bagImage2 = findViewById(R.id.bagImage2);
        bagImage3 = findViewById(R.id.bagImage3);
        bagImage4= findViewById(R.id.bagImage4);
        home = findViewById(R.id.baghomeIcon);
        profile = findViewById(R.id.bagProfileIcon);
        cart = findViewById(R.id.bagCartIcon);
        back = findViewById(R.id.bagBack);
        bagPrice1 = findViewById(R.id.bag1Price);
        bagPrice2 = findViewById(R.id.bag2Price);
        bagPrice3 = findViewById(R.id.bag3Price);
        bagPrice4 = findViewById(R.id.bag4price);

        final ArrayList<String> bahList = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("products");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    if (((HashMap)(dataSnapshot.getValue())).get("category") == "Frocks") {
                        bahList.add(dataSnapshot.getValue().toString());
                    }
                }

                for(int i=0; i<bahList.size(); i++) {

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