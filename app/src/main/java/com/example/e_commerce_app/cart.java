package com.example.e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class cart extends AppCompatActivity {
    Button add;
    TextView cartQuantity, cartQuantity1, cartQuantity2, cartButton1, cartButton2, cartButton3;
    ImageView cartDeleteIcon, cartDeleteIcon1, cartDeleteIcon2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        add = findViewById(R.id.cartButton1);
        add = findViewById(R.id.cartButton2);
        add = findViewById(R.id.cartButton3);
        cartQuantity = findViewById(R.id.cartQuantity);
        cartQuantity1 = findViewById(R.id.cartQuantity1);
        cartQuantity2 = findViewById(R.id.cartQuantity2);
        cartDeleteIcon = findViewById(R.id.cartDeleteIcon);
        cartDeleteIcon1 = findViewById(R.id.cartDeleteIcon1);
        cartDeleteIcon2 = findViewById(R.id.cartDeleteIcon2);
    }
}