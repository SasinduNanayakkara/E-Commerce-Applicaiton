package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class chnage_order extends AppCompatActivity {

    DatabaseReference databaseReference;

    EditText yourName, address, province, postalCode, itemCode, size, quantity, phoneNumber;
    Button changeOrderButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chnage_order);


        changeOrderButton = findViewById(R.id.ChangeOrderButton);

        yourName = findViewById(R.id.changeOrderName);

        address = findViewById(R.id.changeOrderAddress);

        province = findViewById(R.id.changeOrderProvince);

        postalCode = findViewById(R.id.changeOrderPostalCode);

        itemCode = findViewById(R.id.changeOrderItemCode);

        size = findViewById(R.id.changeOrderSize);

        quantity = findViewById(R.id.changeOrderQuantity);

        phoneNumber = findViewById(R.id.changeOrderPhone);

        yourName.setText(getIntent().getStringExtra("yourName"));
        address.setText(getIntent().getStringExtra("address"));
        province.setText(getIntent().getStringExtra("province"));
        postalCode.setText(getIntent().getStringExtra("postalCode"));
        itemCode.setText(getIntent().getStringExtra("itemCode"));
        size.setText(getIntent().getStringExtra("size"));
        quantity.setText(getIntent().getStringExtra("quantity"));
        phoneNumber.setText(getIntent().getStringExtra("phoneNumber"));

        changeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = yourName.getText().toString();
                String add = address.getText().toString();
                String pro = province.getText().toString();
                String postal = postalCode.getText().toString();
                String item = itemCode.getText().toString();
                String siz = size.getText().toString();
                String qua = quantity.getText().toString();
                String pNum = phoneNumber.getText().toString();


                chnage_order(name, add, pro, postal,item, siz, qua, pNum);
            }
        });

    }

    private void chnage_order(String YourName, String Address, String Province, String PostalCode, String ItemCode, String Size, String Quantity, String PhoneNumber){

        HashMap Order = new HashMap();
        Order.put("yourName", YourName);
        Order.put("address", Address);
        Order.put("province", Province);
        Order.put("postalCode", PostalCode);
        Order.put("itemCode", ItemCode);
        Order.put("size", Size);
        Order.put("quantity", Quantity);
        Order.put("phoneNumber", PhoneNumber);

        databaseReference = FirebaseDatabase.getInstance().getReference("Orders");
        databaseReference.child(YourName).updateChildren(Order).addOnCompleteListener(new OnCompleteListener(){
            @Override
            public void onComplete(@NonNull Task task){
                if(task.isSuccessful()) {
                    yourName.setText("");
                    address.setText("");
                    province.setText("");
                    postalCode.setText("");
                    itemCode.setText("");
                    size.setText("");
                    quantity.setText("");
                    phoneNumber.setText("");
                    Toast.makeText(chnage_order.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), buy_now.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(chnage_order.this, "Failed to Update", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}