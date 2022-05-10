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

public class trousers extends AppCompatActivity {
    ImageView trouserImage1, trouserImage2, trouserImage3, trouserImage4, home, cart, profile, back;
    TextView trouserPrice1, trouserPrice2, trouserPrice3, trouserPrice4;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trousers);

        trouserImage1 = findViewById(R.id.trouserImage1);
        trouserImage2 = findViewById(R.id.trouserImage2);
        trouserImage3 = findViewById(R.id.trouserImage3);
        trouserImage4 = findViewById(R.id.trouserImage4);
        home = findViewById(R.id.trouserHomeIcon);
        cart = findViewById(R.id.trouserCartIcon);
        profile = findViewById(R.id.trouserProfileIcon);
        trouserPrice1 = findViewById(R.id.trouserPrice1);
        trouserPrice2 = findViewById(R.id.trouserPrice2);
        trouserPrice3 = findViewById(R.id.trouserPrice3);
        trouserPrice4 = findViewById(R.id.trouserPrice4);

        String isAdmin = getIntent().getStringExtra("isAdmin");


        String item = "Trousers";

        readData(item);

        trouserImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("T100").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("T100").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("T100").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("T100").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("T100").child("description").getValue()));

                            if (isAdmin.equals("false")) {
                                Intent intent = new Intent(getApplicationContext(), single_product.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "tr1");
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
                                intent.putExtra("image", "tr1");
                                intent.putExtra("category", item);

                                startActivity(intent);
                            }
                        }
                    }
                });
            }
        });

        trouserImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("T101").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("T101").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("T101").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("T101").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("T101").child("description").getValue()));

                            if (isAdmin.equals("false")) {
                                Intent intent = new Intent(getApplicationContext(), single_product.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "tr2");
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
                                intent.putExtra("image", "tr2");
                                intent.putExtra("category", item);

                                startActivity(intent);
                            }
                        }
                    }
                });
            }
        });

        trouserImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("T102").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("T102").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("T102").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("T102").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("T102").child("description").getValue()));

                            if (isAdmin.equals("false")) {
                                Intent intent = new Intent(getApplicationContext(), single_product.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "tr3");
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
                                intent.putExtra("image", "tr3");
                                intent.putExtra("category", item);

                                startActivity(intent);
                            }
                        }
                    }
                });
            }
        });

        trouserImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("T103").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("T103").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("T103").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("T103").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("T103").child("description").getValue()));

                            if (isAdmin.equals("false")) {
                                Intent intent = new Intent(getApplicationContext(), single_product.class);
                                intent.putExtra("itemName", product.getItemName());
                                intent.putExtra("itemCode", product.getItemCode());
                                intent.putExtra("description", product.getDescription());
                                intent.putExtra("price", product.getPrice());
                                intent.putExtra("size", product.getSize());
                                intent.putExtra("image", "tr7");
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
                                intent.putExtra("image", "tr7");
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
                        trouserPrice1.setText("LKR " + String.valueOf(dataSnapshot.child("T100").child("price").getValue()));
                        trouserPrice2.setText("LKR" + String.valueOf(dataSnapshot.child("T101").child("price").getValue()));
                        trouserPrice3.setText("LKR" + String.valueOf(dataSnapshot.child("T102").child("price").getValue()));
                        trouserPrice4.setText("LKR" + String.valueOf(dataSnapshot.child("T103").child("price").getValue()));
                    }
                }
                else {
                    Toast.makeText(trousers.this, "Failed to read", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}