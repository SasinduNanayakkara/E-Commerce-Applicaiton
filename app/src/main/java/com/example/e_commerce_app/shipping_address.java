package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class shipping_address extends AppCompatActivity {
    Button add;
    TextView NameN, Address1, Address2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_address);

        getSupportActionBar().hide();

        add = findViewById(R.id.EditAddressButton);
        NameN = findViewById(R.id.NameN);
        Address1 = findViewById(R.id.Address1);
        Address2 = findViewById(R.id.Address2);

        final ArrayList<String> shippingAddressList = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_shoes, shippingAddressList);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("Products");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    shippingAddressList.add(dataSnapshot.getValue().toString());

                }
                ArrayList<String> elements = new ArrayList<>();

                adapter.notifyDataSetChanged();
                final ArrayList<String> item = new ArrayList<>();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}