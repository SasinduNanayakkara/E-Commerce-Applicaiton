package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

public class update_new_item extends AppCompatActivity {

    EditText updateName, updateDescription, updateCode, updateImage, updatePrice, updateCategory, updateSize;
    Button updateBtn;

    Task databaseReference;

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

        Product product = new Product();

        updateName.setText(product.getItemName());
        updateCode.setText(product.getItemCode());
        updateDescription.setText(product.getDescription());
        updatePrice.setText(product.getPrice());
        updateSize.setText(product.getSize());

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = updateName.getText().toString();
                String itemCode = updateCode.getText().toString();
                String Description = updateDescription.getText().toString();
                String price = updatePrice.getText().toString();
                String size = updateSize.getText().toString();

                updateData(itemName, itemCode, Description, price,size);
            }
        });


    }

    private void updateData(String itemName, String itemCode, String Description, String price, String size) {

        HashMap product = new HashMap();
        product.put("itemName", itemName);
        product.put("itemCode", itemCode);
        product.put("description", Description);
        product.put("price", price);
        product.put("size", size);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("products").updateChildren(product).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()) {
                    updateName.setText("");
                    updateCode.setText("");
                    updateDescription.setText("");
                    updatePrice.setText("");
                    updateSize.setText("");

                    Toast.makeText(update_new_item.this, "Data updated Successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(update_new_item.this, "Failed ti update", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}