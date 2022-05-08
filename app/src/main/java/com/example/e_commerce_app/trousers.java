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

public class trousers extends AppCompatActivity {
    ImageView trouserImage1, trouserImage2, trouserImage3, trouserImage4, home, cart, profile, back;
    TextView trouserPrice1, trouserPrice2, trouserPrice3, trouserPrice4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trousers);

        trouserImage1 = findViewById(R.id.trouserImage1);
        trouserImage2 = findViewById(R.id.trouserImage2);
        trouserImage3 = findViewById(R.id.trouserImage3);
        trouserImage4 = findViewById(R.id.trouserImage4);
        home = findViewById(R.id.trouserHomeIcon);
        cart = findViewById(R.id.trouserCartIcon);
        profile = findViewById(R.id.trouserProfileIcon);
        trouserPrice1 = findViewById(R.id.trouserPrice1);
        trouserPrice2 = findViewById(R.id.trouserPrice2);
        trouserPrice3 = findViewById(R.id.trouserPrice3);
        trouserPrice4 = findViewById(R.id.trouserPrice4);


        final ArrayList<String> trouserList = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("products");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    if (((HashMap)(dataSnapshot.getValue())).get("category") == "Trousers") {
                        trouserList.add(dataSnapshot.getValue().toString());
                    }
                }

                for(int i=0; i<trouserList.size(); i++) {

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