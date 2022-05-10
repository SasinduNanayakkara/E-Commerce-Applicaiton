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

public class jewelry extends AppCompatActivity {

    ImageView jImage1, jImage2, jImage3, jImage4, home, cart, back, profile;
    TextView jPrice1, jPrice2, jPrice3, jPrice4;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewelry);

        jImage1 = findViewById(R.id.jImage1);
        jImage2 = findViewById(R.id.jImage2);
        jImage3 = findViewById(R.id.jImage3);
        jImage4 = findViewById(R.id.jImage4);
        home = findViewById(R.id.jHome);
        cart = findViewById(R.id.jCart);
        profile = findViewById(R.id.jProfile);
        back = findViewById(R.id.jBackIcon);
        jPrice1 = findViewById(R.id.jPrice1);
        jPrice2 = findViewById(R.id.jPrice2);
        jPrice3 = findViewById(R.id.jPrice3);
        jPrice4 = findViewById(R.id.jPrice4);

        String isAdmin = getIntent().getStringExtra("isAdmin");


        String item = "Jewelery";

        readData(item);

        jImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("J100").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("J100").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("J100").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("J100").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("J100").child("description").getValue()));

                            if (isAdmin.equals("false")) {
                                Intent intent = new Intent(getApplicationContext(), single_product.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "j1");
                                intent.putExtra("category", item);
                                startActivity(intent);

                            }
                            else {
                                Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "j1");
                                intent.putExtra("category", item);

                                startActivity(intent);
                            }
                        }
                    }
                });
            }
        });

        jImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("J101").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("J101").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("J101").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("J101").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("J101").child("description").getValue()));

                            if (isAdmin.equals("false")) {
                                Intent intent = new Intent(getApplicationContext(), single_product.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "j7");
                                intent.putExtra("category", item);
                                startActivity(intent);

                            }
                            else {
                                Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "j7");
                                intent.putExtra("category", item);

                                startActivity(intent);
                            }
                        }
                    }
                });
            }
        });

        jImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("J102").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("J102").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("J102").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("J102").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("J102").child("description").getValue()));

                            if (isAdmin.equals("false")) {
                                Intent intent = new Intent(getApplicationContext(), single_product.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "j4");
                                intent.putExtra("category", item);
                                startActivity(intent);

                            }
                            else {
                                Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "j4");
                                intent.putExtra("category", item);

                                startActivity(intent);
                            }
                        }
                    }
                });
            }
        });

        jImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("J103").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("J103").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("J103").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("J103").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("J103").child("description").getValue()));

                            if (isAdmin.equals("false")) {
                                Intent intent = new Intent(getApplicationContext(), single_product.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "j5");
                                intent.putExtra("category", item);
                                startActivity(intent);

                            }
                            else {
                                Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "j5");
                                intent.putExtra("category", item);

                                startActivity(intent);
                            }
                        }
                    }
                });
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
                        jPrice1.setText("LKR " + String.valueOf(dataSnapshot.child("J100").child("price").getValue()));
                        jPrice2.setText("LKR" + String.valueOf(dataSnapshot.child("J101").child("price").getValue()));
                        jPrice3.setText("LKR" + String.valueOf(dataSnapshot.child("J102").child("price").getValue()));
                        jPrice4.setText("LKR" + String.valueOf(dataSnapshot.child("J103").child("price").getValue()));
                    }
                }
                else {
                    Toast.makeText(jewelry.this, "Failed to read", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}