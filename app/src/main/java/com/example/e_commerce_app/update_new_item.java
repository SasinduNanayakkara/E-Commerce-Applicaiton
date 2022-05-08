package com.example.e_commerce_app;

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

public class update_new_item extends AppCompatActivity {

    EditText updateName, updateDescription, updateCode, updateImage, updatePrice, updateCategory, updateSize;
    Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_new_item);

        updateName = findViewById(R.id.updateItemName);
        updateCode = findViewById(R.id.updateItemCode);
        updateDescription = findViewById(R.id.updateDescription);
        updatePrice = findViewById(R.id.updatePrice);
        updateImage = findViewById(R.id.updateImageUrl);
        updateSize = findViewById(R.id.updateSize);
        updateCategory = findViewById(R.id.updateCategory);
        updateBtn = findViewById(R.id.updateItemBtn);

        final ArrayList<String> itemList = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_shoes, itemList);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("Products");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    System.out.println(((HashMap)(dataSnapshot.getValue())).get("category"));
                    itemList.add(dataSnapshot.getValue().toString());

                }

                HashMap<String, String> product = new HashMap<>();
                for (String s : itemList.get(3).replaceAll("\\{", "").replaceAll("\\}", "").split(",")) {
                    product.put(s.trim().split("=")[0], s.trim().split("=")[1]);
                }

                adapter.notifyDataSetChanged();

                System.out.println(itemList.get(3));

                System.out.println(product);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}