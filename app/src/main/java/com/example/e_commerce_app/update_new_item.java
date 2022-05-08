package com.example.e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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



    }
}