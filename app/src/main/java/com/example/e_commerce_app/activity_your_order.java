package com.example.e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.e_commerce_app.viewmodel.OrderViewModel;

public class activity_your_order extends AppCompatActivity {

    TextView yourName, address, province, postalCode, itemCode, size, quantity, phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_your_order);

        yourName = findViewById(R.id.editTextTextPersonName);
        address = findViewById(R.id.editTextTextPersonName2);
        province = findViewById(R.id.editTextTextPersonName3);
        postalCode = findViewById(R.id.editTextTextPersonName4);
        itemCode = findViewById(R.id.editTextTextPersonName5);
        size = findViewById(R.id.editTextTextPersonName6);
        quantity = findViewById(R.id.editTextTextPersonName7);
       phoneNumber = findViewById(R.id.editTextTextPersonName8);


        if(getIntent().getExtras() != null) {

            OrderViewModel orderDetailsObj = (OrderViewModel) getIntent().getSerializableExtra("obj");

            yourName.setText(orderDetailsObj.getYourName());
            address.setText(orderDetailsObj.getAddress());
            province.setText(orderDetailsObj.getProvince());
            postalCode.setText(orderDetailsObj.getPostalCode());
            itemCode.setText(orderDetailsObj.getItemCode());
            size.setText(orderDetailsObj.getSize());
            quantity.setText(orderDetailsObj.getQuantity());
            phoneNumber.setText(orderDetailsObj.getPhoneNumber());


        }

    }
}