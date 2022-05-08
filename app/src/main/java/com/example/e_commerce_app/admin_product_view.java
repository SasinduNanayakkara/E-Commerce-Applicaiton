package com.example.e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class admin_product_view extends AppCompatActivity {

    ImageView productImage, back;
    TextView productName, productDescription, productPrice, productSize;
    Button updateBtn, deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_product_view);

        productImage =findViewById(R.id.productImage);
        back = findViewById(R.id.productBack);
        productName = findViewById(R.id.singleProductName);
        productDescription = findViewById(R.id.productDescription);
        productPrice = findViewById(R.id.SingleProductPrice);
        productSize = findViewById(R.id.SingleProductSize);
        updateBtn = findViewById(R.id.SingleProductUpdate);
        deleteBtn = findViewById(R.id.SingleProductDelete);

        Product item = new Product();

        productName.setText(item.getItemName());
        productDescription.setText(item.getDescription());
        productPrice.setText(item.getPrice());
        productSize.setText(item.getSize());

        try {
            URL url = new URL(item.getImageUrl());
            InputStream image = (InputStream)url.getContent();
            Drawable itemImage = Drawable.createFromStream(image, "src");
            productImage.setImageDrawable(itemImage);

        } catch (Exception e) {
            e.printStackTrace();
        }

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), update_new_item.class);
                startActivity(intent);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //delete function
            }
        });
    }
}