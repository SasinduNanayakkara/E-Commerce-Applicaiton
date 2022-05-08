package com.example.e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_commerce_app.viewmodel.OrderViewModel;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.HashMap;

public class buy_now extends AppCompatActivity {
    Button add;
    EditText YourNameInput, AddressInput, ProvinceInput, PostalCodeInput, ItemCodeInput, SizeInput, QuantityInput, PhoneNumberInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_buy_now);

        add = findViewById(R.id.PlaceYourOrderButton);
        YourNameInput = findViewById(R.id.YourNameInput);
        AddressInput = findViewById(R.id.AddressInput);
        ProvinceInput = findViewById(R.id.ProvinceInput);
        PostalCodeInput = findViewById(R.id.PostalCodeInput);
        ItemCodeInput = findViewById(R.id.ItemCodeInput);
        SizeInput = findViewById(R.id.SizeInput);
        QuantityInput = findViewById(R.id.QuantityInput);
        PhoneNumberInput = findViewById(R.id.PhoneNumberInput);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yourName = YourNameInput.getText().toString();
                String address = AddressInput.getText().toString();
                String province = ProvinceInput.getText().toString();
                String postalCode = PostalCodeInput.getText().toString();
                String itemCode = ItemCodeInput.getText().toString();
                String size = SizeInput.getText().toString();
                String quantity = QuantityInput.getText().toString();
                String phoneNumber = PhoneNumberInput.getText().toString();

                if (yourName.isEmpty() || address.isEmpty() || province.isEmpty() || postalCode.isEmpty() || itemCode.isEmpty() || size.isEmpty() || quantity.isEmpty() || phoneNumber.isEmpty()) {
                    Toast.makeText(buy_now.this, "Empty input fields not allowed", Toast.LENGTH_SHORT).show();
                }
                else {

                    HashMap<String, Object> map = new HashMap<>();
                    map.put("yourName", yourName);
                    map.put("address", address);
                    map.put("province", province);
                    map.put("postalCode", postalCode);
                    map.put("itemCode", itemCode);
                    map.put("size", size);
                    map.put("quantity", quantity);
                    map.put("phoneNumber", phoneNumber);

                    OrderViewModel vm = new OrderViewModel();

                    vm.setYourName(yourName);
                    vm.setAddress(address);
                    vm.setProvince(province);
                    vm.setPostalCode(postalCode);
                    vm.setItemCode(itemCode);
                    vm.setSize(size);
                    vm.setQuantity(quantity);
                    vm.setPhoneNumber(phoneNumber);

                    Toast.makeText(buy_now.this, "Oder placed successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), activity_your_order.class);
                    intent.putExtra("obj",vm);
                    startActivity(intent);
                }
            }
        });
    }
}