package com.example.e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class payment extends AppCompatActivity {
    Button add;
    EditText CardNumberInput, ExpiryDateInput, CVVInput, CardHolderNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_payment);

        add = findViewById(R.id.PayButton);
        CardNumberInput = findViewById(R.id.CardNumberInput);
        ExpiryDateInput = findViewById(R.id.ExpiryDateInput);
        CVVInput = findViewById(R.id.CVVInput);
        CardHolderNameInput = findViewById(R.id.CardHolderNameInput);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String CardNumber = CardNumberInput.getText().toString();
                String ExpiryDate = ExpiryDateInput.getText().toString();
                String CVV = CVVInput.getText().toString();
                String CardHolderName = CardHolderNameInput.getText().toString();

                if (CardNumber.isEmpty() || ExpiryDate.isEmpty() || CVV.isEmpty() || CardHolderName.isEmpty()) {
                    Toast.makeText(payment.this, "Empty input fields not allowed", Toast.LENGTH_SHORT).show();
                }
                else {

                    HashMap<String, Object> map = new HashMap<>();
                    map.put("CardNumber", CardNumber);
                    map.put("ExpiryDate", ExpiryDate);
                    map.put("CVV", CVV);
                    map.put("CardHolderName", CardHolderName);

                    FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("Payment").push().updateChildren(map);
                    Toast.makeText(payment.this, "Payment successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), buy_now.class);
                    startActivity(intent);
                }
            }
        });
    }
}