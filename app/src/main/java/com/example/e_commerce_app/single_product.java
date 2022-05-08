package com.example.e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class single_product extends AppCompatActivity {

    TextView productName, productDescription, productPrice, productCode;
    Button cart, buyNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product);

        productName = findViewById(R.id.itemName);
        productCode = findViewById(R.id.itemCode);
        productDescription = findViewById(R.id.itemDescription);
        productPrice = findViewById(R.id.itemPrice);
        cart = findViewById(R.id.ItemCartBtn);
        buyNow = findViewById(R.id.itemBuyNow);

        Product item = new Product();

        productName.setText(item.getItemName());
        productDescription.setText(item.getDescription());
        productPrice.setText(item.getPrice());
        productCode.setText(item.getItemCode());

        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), buy_now.class);
                startActivity(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.e_commerce_app.cart.class);
                startActivity(intent);
            }
        });

    }
}