package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class shipping_address extends AppCompatActivity {
    Button add;
    EditText Address;
    TextView Name;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_address);

        getSupportActionBar().hide();

        add = findViewById(R.id.EditAddressButton);
        Address = findViewById(R.id.AddressInput);
        Name = findViewById(R.id.ShippingAddressName);

        Name.setText(getIntent().getStringExtra("name"));
        Address.setText(getIntent().getStringExtra("address"));
        String password = getIntent().getStringExtra("password");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData(Address.getText().toString(), password);
            }
        });


    }
    private void updateData(String Address, String password) {
        HashMap product  = new HashMap();
        product.put("address", Address);
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.child(password).updateChildren(product).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()){
                    Toast.makeText(shipping_address.this, "Data updated Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), home.class);
                }

            }
        });
    }
}