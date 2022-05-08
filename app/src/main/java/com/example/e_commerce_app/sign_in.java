package com.example.e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sign_in extends AppCompatActivity {

    EditText signinEmail,signPassword;
    Button signinBtn;
    TextView signinForgetPsssword;
    TextView signinRegister;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signinEmail = findViewById(R.id.signinEmail);
        signPassword = findViewById(R.id.signPassword);
        signinBtn = findViewById(R.id.signinBtn);
        signinForgetPsssword = findViewById(R.id.signinForgetPsssword);
        signinRegister=findViewById(R.id.signinRegister);


        //get current instance of firebase authentication
        fAuth = FirebaseAuth.getInstance();


        // if the user is not registered
        signinRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), register.class));
               // overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
            }
        });

        // Login to the system when clicks the login button
        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text_email = signinEmail.getText().toString().trim();
                String text_password = signPassword.getText().toString().trim();

                //validation
                if(TextUtils.isEmpty(text_email)){
                    signinEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(text_password)){
                    signPassword.setError("Password is required");
                    return;
                }
                if(text_password.length() < 6){
                    signPassword.setError("Password must greater than 6 characters");
                }


                //authenticate user
                fAuth.signInWithEmailAndPassword(text_email, text_password).addOnSuccessListener(new OnSuccessListener<AuthResult>(){
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        Toast.makeText(sign_in.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(sign_in.this, profile.class));
                       // overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
                        finish();
                    }

                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(sign_in.this, "Login Unsuccessful!!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        signinForgetPsssword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText resetemail = new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password");
                passwordResetDialog.setMessage("Enter your email To receive reset link");
                passwordResetDialog.setView(resetemail);

                passwordResetDialog.setPositiveButton("Send Link", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //extract email and send email
                        String mail = resetemail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(sign_in.this, "Reset link sent, Check your mail", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(sign_in.this, "Error!! Link is not sent", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });

                passwordResetDialog.create().show();
            }
        });

       /* login_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Homepage_new.class));
            }
        });*/
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(sign_in.this, "Please Login First", Toast.LENGTH_SHORT).show();
    }
}