package com.example.e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class product_add extends AppCompatActivity {
    Button add;
    EditText ItemNameInput, ImageUrlInput, ItemCodeInput, DescriptionInput, PriceInput, CategoryInput, SizesInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);

        add = findViewById(R.id.NewProductAddButton);
        ItemNameInput = findViewById(R.id.ItemNameInput);
        ImageUrlInput = findViewById(R.id.ImageUrlInput);
        ItemCodeInput = findViewById(R.id.ItemCodeInput);
        DescriptionInput = findViewById(R.id.DescriptionInput);
        PriceInput = findViewById(R.id.PriceInput);
        CategoryInput = findViewById(R.id.CategoryInput);
        SizesInput = findViewById(R.id.SizesInput);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = ItemNameInput.getText().toString();
                String imageUrl = ImageUrlInput.getText().toString();
                String itemCode = ItemCodeInput.getText().toString();
                String description = DescriptionInput.getText().toString();
                String price = PriceInput.getText().toString();
                String category = CategoryInput.getText().toString();
                String size = SizesInput.getText().toString();

                if (itemName.isEmpty() || imageUrl.isEmpty() || itemCode.isEmpty() || description.isEmpty() || price.isEmpty() || category.isEmpty() || size.isEmpty()) {
                    Toast.makeText(product_add.this, "Empty input fields not allowed", Toast.LENGTH_SHORT).show();
                }
                else {

                    HashMap<String, Object> map = new HashMap<>();
                    map.put("itemName", itemName);
                    map.put("imageUrl", imageUrl);
                    map.put("itemCode", itemCode);
                    map.put("description", description);
                    map.put("price", price);
                    map.put("category", category);
                    map.put("size", size);

                    FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("Products").push().updateChildren(map);
                    Toast.makeText(product_add.this, "Product added successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}