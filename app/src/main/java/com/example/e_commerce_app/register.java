package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class register extends AppCompatActivity {

    Button add;
    EditText RegisterName, RegisterEmail, RegisterphoneNumber, RegisterAddress,RegisterCountry,RegisterUsername, RegisterPassword;
    FirebaseDatabase db;
    Task<Void> reference;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        add = findViewById(R.id.button2);
        RegisterName = findViewById(R.id.RegisterName);
        RegisterEmail = findViewById(R.id.RegitserEmail);
        RegisterphoneNumber = findViewById(R.id.RegisterphoneNumber);
        RegisterAddress = findViewById(R.id.RegisterAddress);
        RegisterCountry = findViewById(R.id.RegisterCountry);
        RegisterUsername = findViewById(R.id.RegisterUsername);
        RegisterPassword = findViewById(R.id.RegisterPassword);

        auth = FirebaseAuth.getInstance();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String registerName = RegisterName.getText().toString();
                String registerEmail = RegisterEmail.getText().toString();
                String registerPhoneNumber = RegisterphoneNumber.getText().toString();
                String registerAddress = RegisterAddress.getText().toString();
                String registerCountry = RegisterCountry.getText().toString();
                String registerUsername = RegisterUsername.getText().toString();
                String registerPassword = RegisterPassword.getText().toString();

                if (registerName.isEmpty() || registerEmail.isEmpty() || registerPhoneNumber.isEmpty() || registerAddress.isEmpty() || registerCountry.isEmpty() || registerUsername.isEmpty() || registerPassword.isEmpty()) {
                    Toast.makeText(register.this, "Empty input fields not allowed", Toast.LENGTH_SHORT).show();
                } else if (registerPassword.length() < 6) {
                    Toast.makeText(register.this, "password too short!", Toast.LENGTH_SHORT).show();
                }
                 else {
                    registerUser(registerEmail, registerPassword);

                    registers r = new registers();


                    r.setRegisterName(registerName);
                    r.setRegisterEmail(registerEmail);
                    r.setRegisterPhoneNumber(registerPhoneNumber);
                    r.setRegisterAddress(registerAddress);
                    r.setRegisterCountry(registerCountry);
                    r.setRegisterUsername(registerUsername);
                    r.setRegisterPassword(registerPassword);
                    r.setAdmin(false);

                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference("Users").child(registerPassword).setValue(r).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            RegisterName.setText("");
                            RegisterEmail.setText("");
                            RegisterphoneNumber.setText("");
                            RegisterAddress.setText("");
                            RegisterCountry.setText("");
                            RegisterUsername.setText("");
                            RegisterPassword.setText("");

                            Toast.makeText(register.this, "New user added Successfully", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }

            private void registerUser(String registerEmail, String registerPassword) {

                auth.createUserWithEmailAndPassword(registerEmail, registerPassword).addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(register.this, "Registering user successfull !", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(register.this, "Registering failed !", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }}
