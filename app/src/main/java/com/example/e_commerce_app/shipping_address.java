package com.example.e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class shipping_address extends AppCompatActivity {
    Button add;
    TextView NameN, Address1, Address2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_address);

        add = findViewById(R.id.EditAddressButton);
        NameN = findViewById(R.id.NameN);
        Address1 = findViewById(R.id.Address1);
        Address2 = findViewById(R.id.Address2);
    }
}