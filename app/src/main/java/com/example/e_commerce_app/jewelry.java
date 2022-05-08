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

public class jewelry extends AppCompatActivity {

    ImageView jImage1, jImage2, jImage3, jImage4, home, cart, back, profile;
    TextView jPrice1, jPrice2, jPrice3, jPrice4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewelry);

        jImage1 = findViewById(R.id.jImage1);
        jImage2 = findViewById(R.id.jImage2);
        jImage3 = findViewById(R.id.jImage3);
        jImage4 = findViewById(R.id.jImage4);
        home = findViewById(R.id.jHome);
        cart = findViewById(R.id.jCart);
        profile = findViewById(R.id.jProfile);
        back = findViewById(R.id.jBackIcon);
        jPrice1 = findViewById(R.id.jPrice1);
        jPrice2 = findViewById(R.id.jPrice2);
        jPrice3 = findViewById(R.id.jPrice3);
        jPrice4 = findViewById(R.id.jPrice4);


        final ArrayList<String> jList = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("products");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    if (((HashMap)(dataSnapshot.getValue())).get("category") == "Frocks") {
                        jList.add(dataSnapshot.getValue().toString());
                    }
                }

                for(int i=0; i<jList.size(); i++) {

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