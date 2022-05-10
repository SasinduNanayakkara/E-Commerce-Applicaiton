package com.example.e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class single_product extends AppCompatActivity {

    TextView productName, productDescription, productPrice, productCode;
    Button Cart, buyNow;
    ImageView productImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product);

        productName = findViewById(R.id.itemName);
        productCode = findViewById(R.id.itemCode);
        productDescription = findViewById(R.id.itemDescription);
        productPrice = findViewById(R.id.itemPrice);
        Cart = findViewById(R.id.ItemCartBtn);
        buyNow = findViewById(R.id.itemBuyNow);
        productImage = findViewById(R.id.itemImage);

        Product item = new Product();

        productName.setText(getIntent().getStringExtra("itemName"));
        productDescription.setText(getIntent().getStringExtra("description"));
        productPrice.setText("LKR " + getIntent().getStringExtra("price"));
        //productSize.setText(getIntent().getStringExtra("size"));
        String image = getIntent().getStringExtra("image");
        String category = getIntent().getStringExtra("category");
        String code = getIntent().getStringExtra("itemCode");

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

        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), buy_now.class);
                startActivity(intent);
            }
        });

        Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), cart.class);
                intent.putExtra("itemName",getIntent().getStringExtra("itemName") );
                intent.putExtra("description", getIntent().getStringExtra("description"));
                intent.putExtra("price", getIntent().getStringExtra("price"));
                intent.putExtra("size", getIntent().getStringExtra("size"));
                intent.putExtra("image",  getIntent().getStringExtra("image"));
                intent.putExtra("category", getIntent().getStringExtra("category"));
                intent.putExtra("code", getIntent().getStringExtra("itemCode"));
                startActivity(intent);
            }
        });

    }
}