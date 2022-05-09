package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class home extends AppCompatActivity {

    ImageView frockImage, tShirtImage, trouserImage, jeweleryImage, shoeImage, bagImage, cartIcon, profileIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        frockImage = findViewById(R.id.FrockImageIcon);
        tShirtImage = findViewById(R.id.TShirtImageIcon);
        trouserImage = findViewById(R.id.TrouserImageIcon);
        jeweleryImage = findViewById(R.id.JewelleryImageIcon);
        shoeImage = findViewById(R.id.ShoeImageIcon);
        bagImage = findViewById(R.id.BagImageIcon);
        cartIcon = findViewById(R.id.CartImageIcon);
        profileIcon = findViewById(R.id.profileImageIcon);

        String registerName = getIntent().getStringExtra("registerName");
        String registerEmail = getIntent().getStringExtra("registerEmail");
        String registerPhoneNumber = getIntent().getStringExtra("registerPhoneNumber");
        String registerAddress = getIntent().getStringExtra("registerAddress");
        String registerCountry = getIntent().getStringExtra("registerCountry");
        String  isAdmin = getIntent().getStringExtra("isAdmin");

        profileIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), profile.class);
                intent.putExtra("registerName",  registerName);
                intent.putExtra("registerEmail",  registerEmail);
                intent.putExtra("registerPhoneNumber",  registerPhoneNumber);
                intent.putExtra("registerAddress",  registerAddress);
                intent.putExtra("registerCountry",  registerCountry);
                intent.putExtra("isAdmin", isAdmin );


                startActivity(intent);
            }
        });

        frockImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), frock.class);
                startActivity(intent);
            }
        });

        tShirtImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), tshirts.class);
                startActivity(intent);
            }
        });

        trouserImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), trousers.class);
                startActivity(intent);
            }
        });

        jeweleryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), jewelry.class);
                startActivity(intent);
            }
        });

        shoeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), shoes.class);
                startActivity(intent);
            }
        });

        bagImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), shoes.class);
                startActivity(intent);
            }
        });
    }
}