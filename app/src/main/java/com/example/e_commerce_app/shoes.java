package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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

public class shoes extends AppCompatActivity {

    ImageView shoe1, shoe2, shoe3, shoe4, back, home, cart, profile;
    TextView price1, price2, price3, price4;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);

        shoe1 = findViewById(R.id.shoeImage1);
        shoe2 = findViewById(R.id.shoeImage2);
        shoe3 = findViewById(R.id.shoeImage3);
        shoe4 = findViewById(R.id.shoeImage4);
        back = findViewById(R.id.shoePageBack);
        home = findViewById(R.id.homePageIcon);
        cart = findViewById(R.id.cartIcon);
        profile = findViewById(R.id.profileIcon);
        price1 = findViewById(R.id.shoePrice1);
        price2 = findViewById(R.id.shoePrice2);
        price3 = findViewById(R.id.shoePrice3);
        price4 = findViewById(R.id.shoePrice4);

        String item = "Shoes";

        readData(item);

        shoe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("SE100").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("SE100").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("SE100").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("SE100").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("SE100").child("description").getValue()));

                            //productImage.setImageResource(R.drawable.frock1);
                            Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                            intent.putExtra("itemName", product.getItemName());
                            intent.putExtra("itemCode", product.getItemCode());
                            intent.putExtra("description", product.getDescription());
                            intent.putExtra("price", product.getPrice());
                            intent.putExtra("size", product.getSize());
                            intent.putExtra("image", "sh1");
                            startActivity(intent);

                        }
                    }
                });
            }
        });

        shoe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("SE101").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("SE101").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("SE101").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("SE101").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("SE101").child("description").getValue()));

                            //productImage.setImageDrawable(getDrawable(R.drawable.frock2));
                            Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                            intent.putExtra("itemName", product.getItemName());
                            intent.putExtra("itemCode", product.getItemCode());
                            intent.putExtra("description", product.getDescription());
                            intent.putExtra("price", product.getPrice());
                            intent.putExtra("size", product.getSize());
                            intent.putExtra("image", "sh4");
                            startActivity(intent);
                        }
                    }
                });
            }
        });

        shoe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("SE102").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("SE102").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("SE102").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("SE102").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("SE102").child("description").getValue()));


                            Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                            intent.putExtra("itemName", product.getItemName());
                            intent.putExtra("itemCode", product.getItemCode());
                            intent.putExtra("description", product.getDescription());
                            intent.putExtra("price", product.getPrice());
                            intent.putExtra("size", product.getSize());
                            intent.putExtra("image", "sh7");

                            startActivity(intent);
                        }
                    }
                });
            }
        });

        shoe4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Products");
                reference.child(item).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            Product product = new Product();

                            product.setItemName(String.valueOf(dataSnapshot.child("SE103").child("itemName").getValue()));
                            product.setItemCode(String.valueOf(dataSnapshot.child("SE103").child("itemCode").getValue()));
                            product.setPrice(String.valueOf(dataSnapshot.child("SE103").child("price").getValue()));
                            product.setSize(String.valueOf(dataSnapshot.child("SE103").child("size").getValue()));
                            product.setDescription(String.valueOf(dataSnapshot.child("SE103").child("description").getValue()));

                            //productImage.setImageDrawable(getDrawable(R.drawable.frock5));
                            Intent intent = new Intent(getApplicationContext(), admin_product_view.class);
                            intent.putExtra("itemName", product.getItemName());
                            intent.putExtra("itemCode", product.getItemCode());
                            intent.putExtra("description", product.getDescription());
                            intent.putExtra("price", product.getPrice());
                            intent.putExtra("size", product.getSize());
                            intent.putExtra("image", "sh5");

                            startActivity(intent);
                        }
                    }
                });
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), home.class);
//                startActivity(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), cart.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), profile.class);
//                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), home.class);
//                startActivity(intent);
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
                        price1.setText("LKR " + String.valueOf(dataSnapshot.child("SE100").child("price").getValue()));
                        price2.setText("LKR" + String.valueOf(dataSnapshot.child("SE101").child("price").getValue()));
                        price3.setText("LKR" + String.valueOf(dataSnapshot.child("SE102").child("price").getValue()));
                        price4.setText("LKR" + String.valueOf(dataSnapshot.child("SE103").child("price").getValue()));
                    }
                }
                else {
                    Toast.makeText(shoes.this, "Failed to read", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}