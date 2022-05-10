package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    DatabaseReference databaseReference;

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


        String itemName = getIntent().getStringExtra("itemName");
        String itemCode = getIntent().getStringExtra("code");
        String Description = getIntent().getStringExtra("description");
        String price = getIntent().getStringExtra("price");
        String size = getIntent().getStringExtra("size");
        String category = getIntent().getStringExtra("category");
        String image = getIntent().getStringExtra("image");

        System.out.println(image);

        updateName.setText(itemName);
        updateCode.setText(itemCode);
        updateDescription.setText(Description);
        updatePrice.setText(price);
        updateImage.setText(image);
        updateSize.setText(size);
        updateCategory.setText(category);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateData(updateName.getText().toString(), updateCode.getText().toString(), updateDescription.getText().toString(), updatePrice.getText().toString(),updateSize.getText().toString(), updateImage.getText().toString(), updateCategory.getText().toString());
            }
        });


    }

    private void updateData(String itemName, String itemCode, String Description, String price, String size, String image, String category) {

        HashMap product = new HashMap();
        product.put("itemName", itemName);
        product.put("itemCode", itemCode);
        product.put("description", Description);
        product.put("price", price);
        product.put("size", size);
        product.put("category", category);
        product.put("image", image);

        databaseReference = FirebaseDatabase.getInstance().getReference("Products").child(category);
        databaseReference.child(itemCode).updateChildren(product).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()) {
                    updateName.setText("");
                    updateCode.setText("");
                    updateDescription.setText("");
                    updatePrice.setText("");
                    updateSize.setText("");
                    updateImage.setText("");
                    updateCategory.setText("");

                    Toast.makeText(update_new_item.this, "Data updated Successfully", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(update_new_item.this, "Failed to update", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}