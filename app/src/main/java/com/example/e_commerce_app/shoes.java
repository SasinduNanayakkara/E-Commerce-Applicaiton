package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class shoes extends AppCompatActivity {

    ImageView shoe1, shoe2, shoe3, shoe4, back, home, cart, profile;
    TextView price1, price2, price3, price4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);

        shoe1 = findViewById(R.id.shoeImage1);
        shoe2 = findViewById(R.id.shoeImage2);
        shoe3 = findViewById(R.id.shoeImage3);
        shoe4 = findViewById(R.id.shoeImage4);
        back = findViewById(R.id.shoePageBack);
        home = findViewById(R.id.homePageIcon);
        cart = findViewById(R.id.cartIcon);
        profile = findViewById(R.id.profileIcon);
        price1 = findViewById(R.id.shoePrice1);
        price2 = findViewById(R.id.shoePrice2);
        price3 = findViewById(R.id.shoePrice3);
        price4 = findViewById(R.id.shoePrice4);

        final ArrayList<String> shoeList = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_shoes, shoeList);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("Products");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                shoeList.clear();
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    shoeList.add(dataSnapshot.getValue().toString());

                }
                adapter.notifyDataSetChanged();
                final ArrayList<String> item = new ArrayList<>();


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), home.class);
//                startActivity(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), cart.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), profile.class);
//                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), home.class);
//                startActivity(intent);
            }
        });

    }
}