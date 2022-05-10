package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class tshirts extends AppCompatActivity {
    ImageView tShirt1, tShirt2, tShirt3, tShirt4, home, cart, profile, back;
    TextView tShirtPrice1, tShirtPrice2, tShirtPrice3, tShirtPrice4;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tshirts);

        tShirt1 = findViewById(R.id.tShirtImage1);
        tShirt2 = findViewById(R.id.tShirtImage2);
        tShirt3 = findViewById(R.id.tShirtImage3);
        tShirt4 = findViewById(R.id.tShirtImage4);
        home = findViewById(R.id.tShirtHomeIcon);
        cart = findViewById(R.id.tShirtCartImage);
        profile = findViewById(R.id.tShirtProfileImage);
        back = findViewById(R.id.tShirtBackIcon);
        tShirtPrice1 = findViewById(R.id.tShirtPrice1);
        tShirtPrice2 = findViewById(R.id.tShirtPrice2);
        tShirtPrice3 = findViewById(R.id.tShirtPrice3);
        tShirtPrice4 = findViewById(R.id.tShirtPrice4);

        String item = "TShirts";

        readData(item);

        tShirt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("TS100").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("TS100").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("TS100").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("TS100").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("TS100").child("description").getValue()));

                            //productImage.setImageResource(R.drawable.frock1);
                            Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                            intent.putExtra("itemName", product.getItemName());
                            intent.putExtra("itemCode", product.getItemCode());
                            intent.putExtra("description", product.getDescription());
                            intent.putExtra("price", product.getPrice());
                            intent.putExtra("size", product.getSize());
                            intent.putExtra("image", "tshirt1");
                            intent.putExtra("category", item);

                            startActivity(intent);

                        }
                    }
                });

            }
        });

        tShirt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("TS101").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("TS101").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("TS101").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("TS101").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("TS101").child("description").getValue()));

                            //productImage.setImageDrawable(getDrawable(R.drawable.frock2));
                            Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                            intent.putExtra("itemName", product.getItemName());
                            intent.putExtra("itemCode", product.getItemCode());
                            intent.putExtra("description", product.getDescription());
                            intent.putExtra("price", product.getPrice());
                            intent.putExtra("size", product.getSize());
                            intent.putExtra("image", "tshirt2");
                            intent.putExtra("category", item);

                            startActivity(intent);
                        }
                    }
                });
            }
        });

        tShirt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("TS102").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("TS102").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("TS102").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("TS102").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("TS102").child("description").getValue()));


                            Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                            intent.putExtra("itemName", product.getItemName());
                            intent.putExtra("itemCode", product.getItemCode());
                            intent.putExtra("description", product.getDescription());
                            intent.putExtra("price", product.getPrice());
                            intent.putExtra("size", product.getSize());
                            intent.putExtra("image", "tshirt3");
                            intent.putExtra("category", item);

                            startActivity(intent);
                        }
                    }
                });
            }
        });

        tShirt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("TS103").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("TS103").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("TS103").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("TS103").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("TS103").child("description").getValue()));

                            //productImage.setImageDrawable(getDrawable(R.drawable.frock5));
                            Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                            intent.putExtra("itemName", product.getItemName());
                            intent.putExtra("itemCode", product.getItemCode());
                            intent.putExtra("description", product.getDescription());
                            intent.putExtra("price", product.getPrice());
                            intent.putExtra("size", product.getSize());
                            intent.putExtra("image", "tshirt5");
                            intent.putExtra("category", item);

                            startActivity(intent);
                        }
                    }
                });
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.e_commerce_app.home.class);
                startActivity(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.e_commerce_app.cart.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.e_commerce_app.profile.class);
                startActivity(intent);
            }
        });


    }

    private void readData(String item) {
        reference = FirebaseDatabase.getInstance().getReference("Products");
        reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult().exists()) {
                        DataSnapshot dataSnapshot = task.getResult();
                        tShirtPrice1.setText("LKR " + String.valueOf(dataSnapshot.child("TS100").child("price").getValue()));
                        tShirtPrice2.setText("LKR" + String.valueOf(dataSnapshot.child("TS101").child("price").getValue()));
                        tShirtPrice3.setText("LKR" + String.valueOf(dataSnapshot.child("TS102").child("price").getValue()));
                        tShirtPrice4.setText("LKR" + String.valueOf(dataSnapshot.child("TS103").child("price").getValue()));
                    }
                }
                else {
                    Toast.makeText(tshirts.this, "Failed to read", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}