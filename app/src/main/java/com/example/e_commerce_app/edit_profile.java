package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class edit_profile extends AppCompatActivity {

    DatabaseReference databaseReference;

    EditText name, email, pNumber, address, country;
    Button ProfileSaveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        ProfileSaveButton = findViewById(R.id.ProfileSaveButton);
        name = findViewById(R.id.ProfileNameInput);
        email = findViewById(R.id.ProfileEmailInput);
        pNumber = findViewById(R.id.ProfilePhoneInput);
        address = findViewById(R.id.ProfileAddressInput);
        country= findViewById(R.id.ProfileCountryInput);


        name.setText(getIntent().getStringExtra("registerName"));
        email.setText(getIntent().getStringExtra("registerEmail"));
        pNumber.setText(getIntent().getStringExtra("registerPhoneNumber"));
        address.setText(getIntent().getStringExtra("registerAddress"));
        country.setText(getIntent().getStringExtra("registerCountry"));


        ProfileSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nam = name.getText().toString();
                String ema = email.getText().toString();
                String pNum = pNumber.getText().toString();
                String add = address.getText().toString();
                String con = country.getText().toString();


                editProfile(nam, ema, pNum, add,con);
            }
        });

    }

    private void editProfile(String Name, String Email, String PNumber, String Address, String Country){

        HashMap profile = new HashMap();
        profile.put("registerName", Name);
        profile.put("registerEmail", Email);
        profile.put("registerPhoneNumber", PNumber);
        profile.put("registerAddress", Address);
        profile.put("registerCountry", Country);

        String rPassword = getIntent().getStringExtra("registerPassword");
        System.out.println(rPassword);

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.child(rPassword).updateChildren(profile).addOnCompleteListener(new OnCompleteListener(){
            @Override
            public void onComplete(@NonNull Task task){
                if(task.isSuccessful()) {
                    name.setText("");
                    email.setText("");
                    pNumber.setText("");
                    address.setText("");
                    country.setText("");

                    Toast.makeText(edit_profile.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), sign_in.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(edit_profile.this, "Failed to Update", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}