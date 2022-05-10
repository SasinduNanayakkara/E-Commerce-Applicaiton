package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class profile extends AppCompatActivity {

    TextView registerName,registerEmail,registerPhoneNumber,registerAddress,registerCountry;
    Button updatebutton,deletebutton;
    FirebaseAuth fAuth;
    DatabaseReference databaseReference;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        registerName = findViewById(R.id.textView4);
        registerEmail = findViewById(R.id.textView6);
        registerPhoneNumber = findViewById(R.id.textView8);
        registerAddress = findViewById(R.id.textView10);
        registerCountry = findViewById(R.id.textView12);
        updatebutton= findViewById(R.id.button);
        deletebutton = findViewById(R.id.button13);

        //get current instance of firebase authentication
        fAuth = FirebaseAuth.getInstance();

        //check whether user is not logged in, return to Login page
        if (fAuth.getCurrentUser() == null){
            Intent i = new Intent(getApplicationContext(), profile.class).putExtra("from", "Users");
            startActivity(i);
        }
        else{
            userID = fAuth.getCurrentUser().getUid();
            FirebaseUser Users = fAuth.getCurrentUser();

            //fetch user data from DB
            /*databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(userID);
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    //assign values to text fields
                    text_name.setText(snapshot.child("Name").getValue().toString());
                    text_email.setText(snapshot.child("Email").getValue().toString());
                    text_phone.setText(snapshot.child("Phone Number").getValue().toString());
                    text_add.setText(snapshot.child("Address").getValue().toString());
                    text_country.setText(snapshot.child("Country").getValue().toString());
                    user_name.setText(snapshot.child(" ").getValue().toString());

                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });*/

            String rName = getIntent().getStringExtra("registerName");
            String rEmail = getIntent().getStringExtra("registerEmail");
            String rPhoneNumber = getIntent().getStringExtra("registerPhoneNumber");
            String rAddress = getIntent().getStringExtra("registerAddress");
            String rCountry = getIntent().getStringExtra("registerCountry");
            String admin = getIntent().getStringExtra("isAdmin");
            String rpassword = getIntent().getStringExtra("registerPassword");

            registerName.setText(rName);
            registerEmail.setText(rEmail);
            registerPhoneNumber.setText(rPhoneNumber);
            registerAddress.setText(rAddress);
            registerCountry.setText(rCountry);




            updatebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), edit_profile.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    System.out.println(rpassword);

                    intent.putExtra("registerName",  rName);
                    intent.putExtra("registerEmail",  rEmail);
                    intent.putExtra("registerPhoneNumber",  rPhoneNumber);
                    intent.putExtra("registerAddress",  rAddress);
                    intent.putExtra("registerCountry",  rCountry);
                    intent.putExtra("registerPassword", rpassword );

                    startActivity(intent);
                }
            });

        }

        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(profile.this, sign_in.class));
            }
        });

    }
}