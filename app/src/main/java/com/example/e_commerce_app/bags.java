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

public class bags extends AppCompatActivity {

    ImageView bagImage1, bagImage2, bagImage3, bagImage4, home, back, cart, profile;
    TextView bagPrice1, bagPrice2, bagPrice3, bagPrice4;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bags);

        bagImage1 = findViewById(R.id.bagImage1);
        bagImage2 = findViewById(R.id.bagImage2);
        bagImage3 = findViewById(R.id.bagImage3);
        bagImage4= findViewById(R.id.bagImage4);
        home = findViewById(R.id.baghomeIcon);
        profile = findViewById(R.id.bagProfileIcon);
        cart = findViewById(R.id.bagCartIcon);
        back = findViewById(R.id.bagBack);
        bagPrice1 = findViewById(R.id.bag1Price);
        bagPrice2 = findViewById(R.id.bag2Price);
        bagPrice3 = findViewById(R.id.bag3Price);
        bagPrice4 = findViewById(R.id.bag4price);

        String isAdmin = getIntent().getStringExtra("isAdmin");

        String item = "Bags";

        readData(item);

        bagImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("B100").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("B100").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("B100").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("B100").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("B100").child("description").getValue()));

                            //productImage.setImageResource(R.drawable.frock1);
                            if (isAdmin.equals("false")) {
                                Intent intent = new Intent(getApplicationContext(), single_product.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "bg1");
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
                                intent.putExtra("image", "bg1");
                                intent.putExtra("category", item);
                                startActivity(intent);
                            }
                        }
                    }
                });
            }
        });

        bagImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("B101").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("B101").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("B101").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("B101").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("B101").child("description").getValue()));

                            if (isAdmin.equals("false")) {
                                Intent intent = new Intent(getApplicationContext(), single_product.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "bg2");
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
                                intent.putExtra("image", "bg2");
                                intent.putExtra("category", item);

                                startActivity(intent);
                            }
                        }
                    }
                });
            }
        });

        bagImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("B102").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("B102").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("B102").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("B102").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("B102").child("description").getValue()));

                            if (isAdmin.equals("false")) {
                                Intent intent = new Intent(getApplicationContext(), single_product.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "bg5");
                                intent.putExtra("category", item);
                                startActivity(intent);

                            }
                            else  {
                                Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "bg5");
                                intent.putExtra("category", item);

                                startActivity(intent);

                            }
                        }
                    }
                });
            }
        });

        bagImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("B103").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("B103").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("B103").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("B103").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("B103").child("description").getValue()));

                            if (isAdmin.equals("false")) {
                                Intent intent = new Intent(getApplicationContext(), single_product.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "bg8");
                                intent.putExtra("category", item);
                                startActivity(intent);

                            } else {
                                Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "bg8");
                                intent.putExtra("category", item);
                                intent.putExtra("category", item);

                                startActivity(intent);
                            }
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
                        bagPrice1.setText("LKR " + String.valueOf(dataSnapshot.child("B100").child("price").getValue()));
                        bagPrice2.setText("LKR" + String.valueOf(dataSnapshot.child("B101").child("price").getValue()));
                        bagPrice3.setText("LKR" + String.valueOf(dataSnapshot.child("B102").child("price").getValue()));
                        bagPrice4.setText("LKR" + String.valueOf(dataSnapshot.child("B103").child("price").getValue()));
                    }
                }
                else {
                    Toast.makeText(bags.this, "Failed to read", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}