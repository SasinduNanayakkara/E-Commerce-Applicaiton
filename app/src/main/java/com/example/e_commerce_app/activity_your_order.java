package com.example.e_commerce_app;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.e_commerce_app.viewmodel.OrderViewModel;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class activity_your_order extends AppCompatActivity {

    ImageView back;
    EditText yourName, address, province, postalCode, itemCode, size, quantity, phoneNumber;

    Button payNowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_your_order);

        payNowButton = findViewById(R.id.button2);
        back = findViewById(R.id.productBack);

        yourName = findViewById(R.id.editTextTextPersonName);
        yourName.setEnabled(false);

        address = findViewById(R.id.editTextTextPersonName2);
        address.setEnabled(false);

        province = findViewById(R.id.editTextTextPersonName3);
        province.setEnabled(false);

        postalCode = findViewById(R.id.editTextTextPersonName4);
        postalCode.setEnabled(false);

        itemCode = findViewById(R.id.editTextTextPersonName5);
        itemCode.setEnabled(false);

        size = findViewById(R.id.editTextTextPersonName6);
        size.setEnabled(false);

        quantity = findViewById(R.id.editTextTextPersonName7);
        quantity.setEnabled(false);

        phoneNumber = findViewById(R.id.editTextTextPersonName8);
        phoneNumber.setEnabled(false);


        if(getIntent().getExtras() != null) {

            OrderViewModel orderDetailsObj = (OrderViewModel)
                    getIntent().getSerializableExtra("obj");

            yourName.setText(orderDetailsObj.getYourName());
            address.setText(orderDetailsObj.getAddress());
            province.setText(orderDetailsObj.getProvince());
            postalCode.setText(orderDetailsObj.getPostalCode());
            itemCode.setText(orderDetailsObj.getItemCode());
            size.setText(orderDetailsObj.getSize());
            quantity.setText(orderDetailsObj.getQuantity());
            phoneNumber.setText(orderDetailsObj.getPhoneNumber());

            payNowButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("yourName", orderDetailsObj.getYourName());
                        map.put("address", orderDetailsObj.getAddress());
                        map.put("province", orderDetailsObj.getProvince());
                        map.put("postalCode", orderDetailsObj.getPostalCode());
                        map.put("itemCode", orderDetailsObj.getItemCode());
                        map.put("size", orderDetailsObj.getSize());
                        map.put("quantity", orderDetailsObj.getQuantity());
                        map.put("phoneNumber", orderDetailsObj.getPhoneNumber());

                        FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("Orders").push().updateChildren(map);

                    routePaymentActivity();

                }
            });

        }


    }



    //Private Methods
    private void routePaymentActivity(){
        Intent intent = new Intent(activity_your_order.this, payment.class);
        startActivity(intent);
    }

}