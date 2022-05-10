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
        productName.setText(getIntent().getStringExtra("itemName"));
        productDescription.setText(getIntent().getStringExtra("description"));
        productPrice.setText("LKR " + getIntent().getStringExtra("price"));
        productSize.setText(getIntent().getStringExtra("size"));
        String image = getIntent().getStringExtra("image");

        if (image.equals("frock1")){
            productImage.setImageResource(R.drawable.frock1);
        }
        if (image.equals("frock2")){
            productImage.setImageResource(R.drawable.frock2);
        }
        if (image.equals("frock4")){
            productImage.setImageResource(R.drawable.frock4);
        }
        if (image.equals("frock5")){
            productImage.setImageResource(R.drawable.frock5);
        }
        if (image.equals("bg1")){
            productImage.setImageResource(R.drawable.bg1);
        }
        if (image.equals("bg2")){
            productImage.setImageResource(R.drawable.bg2);
        }
        if (image.equals("bg5")){
            productImage.setImageResource(R.drawable.bg5);
        }
        if (image.equals("bg8")){
            productImage.setImageResource(R.drawable.bg8);
        }
        if (image.equals("j1")){
            productImage.setImageResource(R.drawable.j1);
        }
        if (image.equals("j7")){
            productImage.setImageResource(R.drawable.j7);
        }
        if (image.equals("j4")){
            productImage.setImageResource(R.drawable.j4);
        }
        if (image.equals("j5")){
            productImage.setImageResource(R.drawable.j5);
        }
        if (image.equals("sh1")){
            productImage.setImageResource(R.drawable.sh1);
        }
        if (image.equals("sh4")){
            productImage.setImageResource(R.drawable.sh4);
        }
        if (image.equals("sh7")){
            productImage.setImageResource(R.drawable.h7);
        }
        if (image.equals("sh5")){
            productImage.setImageResource(R.drawable.sh5);
        }
        if (image.equals("tr1")){
            productImage.setImageResource(R.drawable.tr1);
        }
        if (image.equals("tr2")){
            productImage.setImageResource(R.drawable.tr2);
        }
        if (image.equals("tr3")){
            productImage.setImageResource(R.drawable.tr3);
        }
        if (image.equals("tr4")){
            productImage.setImageResource(R.drawable.tr7);
        }
        if (image.equals("tshirt1")){
            productImage.setImageResource(R.drawable.tshirt1);
        }
        if (image.equals("tshirt2")){
            productImage.setImageResource(R.drawable.tshirt2);
        }
        if (image.equals("tshirt3")){
            productImage.setImageResource(R.drawable.tshirt3);
        }
        if (image.equals("tshirt5")){
            productImage.setImageResource(R.drawable.tshirt5);
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