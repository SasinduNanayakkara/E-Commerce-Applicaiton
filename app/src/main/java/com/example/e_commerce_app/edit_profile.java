package com.example.e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;


public class edit_profile extends AppCompatActivity {

    EditText ProfileNameInput, ProfileEmailInput, ProfilePhoneInput, ProfileAddressInput, ProfileCountryInput;
    Button ProfileSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ProfileNameInput = findViewById(R.id.ProfileNameInput);
        ProfileEmailInput = findViewById(R.id.ProfileEmailInput);
        ProfilePhoneInput = findViewById(R.id.ProfilePhoneInput);
        ProfileAddressInput = findViewById(R.id.ProfileAddressInput);
        ProfileCountryInput = findViewById(R.id.ProfileCountryInput);
        ProfileSaveButton = findViewById(R.id.ProfileSaveButton);

        final ArrayList<String> profileList = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_edit_profile,profileList);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("Users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    System.out.println(((HashMap)(dataSnapshot.getValue())).get("category"));
                    profileList.add(dataSnapshot.getValue().toString());

                }

                HashMap<String, String> product = new HashMap<>();
                for (String s : profileList.get(3).replaceAll("\\{", "").replaceAll("\\}", "").split(",")) {
                    product.put(s.trim().split("=")[0], s.trim().split("=")[1]);
                }

                adapter.notifyDataSetChanged();

                System.out.println(profileList.get(3));

                System.out.println(product);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}