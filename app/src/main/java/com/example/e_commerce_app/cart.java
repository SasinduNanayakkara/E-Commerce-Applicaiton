package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class cart extends AppCompatActivity {
    Button add;
    TextView cartQuantity, cartQuantity1, cartQuantity2, cartButton1, cartButton2, cartButton3;
    ImageView cartDeleteIcon, cartDeleteIcon1, cartDeleteIcon2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        getSupportActionBar().hide();

        add = findViewById(R.id.cartButton1);
        add = findViewById(R.id.cartButton2);
        add = findViewById(R.id.cartButton3);
        cartQuantity = findViewById(R.id.cartQuantity);
        cartQuantity1 = findViewById(R.id.cartQuantity1);
        cartQuantity2 = findViewById(R.id.cartQuantity2);
        cartDeleteIcon = findViewById(R.id.cartDeleteIcon);
        cartDeleteIcon1 = findViewById(R.id.cartDeleteIcon1);
        cartDeleteIcon2 = findViewById(R.id.cartDeleteIcon2);

        final ArrayList<String> cartItems = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_shoes, cartItems);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("Products");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    cartItems.add(dataSnapshot.getValue().toString());

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