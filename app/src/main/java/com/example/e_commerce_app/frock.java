package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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

public class frock extends AppCompatActivity {

    ImageView frockImage1, frockImage2, frockImage3, frockImage4, homeIcon, cartIcon, profileIcon, backIcon, productImage;
    TextView frockPrice1, frockPrice2, frockPrice3, frockPrice4;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frock);

        frockImage1 = findViewById(R.id.frockImage1);
        frockImage2 = findViewById(R.id.frockImage2);
        frockImage3 = findViewById(R.id.frockImage3);
        frockImage4 = findViewById(R.id.frockImage4);
        homeIcon = findViewById(R.id.frockHomeIcon);
        cartIcon = findViewById(R.id.frockCartIcon);
        profileIcon = findViewById(R.id.frockProfileIcon);
        backIcon = findViewById(R.id.frockBackIcon);
        frockPrice1 = findViewById(R.id.frockPrice1);
        frockPrice2 = findViewById(R.id.frockPrice2);
        frockPrice3 = findViewById(R.id.frockPrice3);
        frockPrice4 = findViewById(R.id.frockPrice4);
        productImage = findViewById(R.id.productImage);


        String item = "Frocks";

        readData(item);

        frockImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("F100").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("F100").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("F100").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("F100").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("F100").child("description").getValue()));

                            //productImage.setImageResource(R.drawable.frock1);
                            Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                            intent.putExtra("itemName", product.getItemName());
                            intent.putExtra("itemCode", product.getItemCode());
                            intent.putExtra("description", product.getDescription());
                            intent.putExtra("price", product.getPrice());
                            intent.putExtra("size", product.getSize());
                            intent.putExtra("image", "frock1");
                            intent.putExtra("category", item);
                            startActivity(intent);

                        }
                    }
                });

                }
        });

        frockImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("F101").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("F101").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("F101").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("F101").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("F101").child("description").getValue()));

                            //productImage.setImageDrawable(getDrawable(R.drawable.frock2));
                            Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                            intent.putExtra("itemName", product.getItemName());
                            intent.putExtra("itemCode", product.getItemCode());
                            intent.putExtra("description", product.getDescription());
                            intent.putExtra("price", product.getPrice());
                            intent.putExtra("size", product.getSize());
                            intent.putExtra("image", "frock2");                            intent.putExtra("category", item);
                            intent.putExtra("category", item);

                            startActivity(intent);
                        }
                    }
                });

            }
        });

        frockImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("F102").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("F102").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("F102").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("F102").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("F102").child("description").getValue()));


                            Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                            intent.putExtra("itemName", product.getItemName());
                            intent.putExtra("itemCode", product.getItemCode());
                            intent.putExtra("description", product.getDescription());
                            intent.putExtra("price", product.getPrice());
                            intent.putExtra("size", product.getSize());
                            intent.putExtra("image", "frock4");
                            intent.putExtra("category", item);

                            startActivity(intent);
                        }
                    }
                });

            }
        });

        frockImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("F103").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("F103").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("F103").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("F103").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("F103").child("description").getValue()));

                            //productImage.setImageDrawable(getDrawable(R.drawable.frock5));
                            Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                            intent.putExtra("itemName", product.getItemName());
                            intent.putExtra("itemCode", product.getItemCode());
                            intent.putExtra("description", product.getDescription());
                            intent.putExtra("price", product.getPrice());
                            intent.putExtra("size", product.getSize());
                            intent.putExtra("image", "frock5");
                            intent.putExtra("category", item);

                            startActivity(intent);
                        }
                    }
                });

            }
        });

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.e_commerce_app.home.class);
                startActivity(intent);
            }
        });

        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.e_commerce_app.cart.class);
                startActivity(intent);
            }
        });

        profileIcon.setOnClickListener(new View.OnClickListener() {
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
                        frockPrice1.setText("LKR " + String.valueOf(dataSnapshot.child("F100").child("price").getValue()));
                        frockPrice2.setText("LKR" + String.valueOf(dataSnapshot.child("F101").child("price").getValue()));
                        frockPrice3.setText("LKR" + String.valueOf(dataSnapshot.child("F102").child("price").getValue()));
                        frockPrice4.setText("LKR" + String.valueOf(dataSnapshot.child("F103").child("price").getValue()));
                    }
                }
                else {
                    Toast.makeText(frock.this, "Failed to read", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}