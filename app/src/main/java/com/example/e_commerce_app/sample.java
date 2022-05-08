package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class sample extends AppCompatActivity {
    TextView sampleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        sampleText = findViewById(R.id.sampleText);


        final ArrayList<String> shoeList = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_shoes, shoeList);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("Products");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    System.out.println(((HashMap)(dataSnapshot.getValue())).get("category"));
                    shoeList.add(dataSnapshot.getValue().toString());

                }

                HashMap<String, String> product = new HashMap<>();
                for (String s : shoeList.get(3).replaceAll("\\{", "").replaceAll("\\}", "").split(",")) {
                    product.put(s.trim().split("=")[0], s.trim().split("=")[1]);
                }
                sampleText.setText(product.get("category"));

                adapter.notifyDataSetChanged();

                System.out.println(shoeList.get(3));

                System.out.println(product);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}