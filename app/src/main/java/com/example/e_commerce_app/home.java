package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        add = findViewById(R.id.ShippingInfo);
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
        String  registerPassword = getIntent().getStringExtra("registerPassword");
        System.out.println("home"+isAdmin);

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
                intent.putExtra("registerPassword", registerPassword );


                startActivity(intent);
            }
        });

        frockImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), frock.class);
                intent.putExtra("isAdmin", isAdmin);
                startActivity(intent);
            }
        });

        tShirtImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), tshirts.class);
                intent.putExtra("isAdmin", isAdmin);
                startActivity(intent);
            }
        });

        trouserImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), trousers.class);
                intent.putExtra("isAdmin", isAdmin);
                startActivity(intent);
            }
        });

        jeweleryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), jewelry.class);
                intent.putExtra("isAdmin", isAdmin);
                startActivity(intent);
            }
        });

        shoeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), shoes.class);
                intent.putExtra("isAdmin", isAdmin);
                startActivity(intent);
            }
        });

        bagImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), shoes.class);
                intent.putExtra("isAdmin", isAdmin);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(), shipping_address.class);
                intent.putExtra("name", registerName);
                intent.putExtra("address", registerAddress);
                intent.putExtra("password", registerPassword);
                startActivity(intent);
            }
        });
    }
}