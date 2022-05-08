package com.example.e_commerce_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    String userId;

    TextView textView4,textView6,textView8,textView10,textView12;

    // TextView email;

    Button button,button13;

    DatabaseReference dbRef;

    ProgressDialog spinner;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //initializing
        textView4 = findViewById(R.id.textView4);
        textView6 = findViewById(R.id.textView6);
        textView8 = findViewById(R.id.textView8);
        textView10 = findViewById(R.id.textView10);
        textView12 = findViewById(R.id.textView12);
        button = findViewById(R.id.button);
        button13 = findViewById(R.id.button13);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        userId = user.getUid();

        getUserDetails();

    }

    @Override
    protected void onResume() {
        super.onResume();

        button .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update userdetails
                button ();
            }
        });





    }

    public void getUserDetails(){

        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Users").child((userId));

        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.hasChildren()){

                    textView4.setText(snapshot.child("registerName").getValue().toString());
                    textView6.setText(snapshot.child("registerEmail").getValue().toString());
                    textView8.setText(snapshot.child("registerPhoneNumber").getValue().toString());
                    textView10.setText(snapshot.child("registerAddress").getValue().toString());
                    textView12.setText(snapshot.child("registerCountry").getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void button(){

        if(validateMobileNumber()){

            dbRef = FirebaseDatabase.getInstance().getReference().child("Users").child(userId);

            dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    dbRef.child("registerName").setValue(textView4.getText().toString().trim());
                    dbRef.child("registerEmail").setValue(textView6.getText().toString().trim());
                    dbRef.child("registerPhoneNumber").setValue(textView8.getText().toString().trim());
                    dbRef.child("registerAddress").setValue(textView10.getText().toString().trim());
                    dbRef.child("registerCountry").setValue(textView12.getText().toString().trim());


                    Toast.makeText(getApplicationContext(),
                            "Successfully updated details",
                            Toast.LENGTH_SHORT)
                            .show();

                    Intent intent = new Intent(profile.this, edit_profile.class);
                    startActivity(intent);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

    }


    public boolean validateMobileNumber()
    {
        String userInputPhoneNumber = textView8.getText().toString();

        if(userInputPhoneNumber.length() == 10)
        {
            return true;
        }
        else {

            Toast.makeText(getApplicationContext(),
                    "Please enter valid phone number",
                    Toast.LENGTH_SHORT)
                    .show();

            return false;
        }

    }


}