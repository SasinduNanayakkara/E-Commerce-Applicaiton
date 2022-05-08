package com.example.e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class contact_us extends AppCompatActivity {
    Button add;
    EditText YourName, YourEmail, YouWantToTalkAbout, YourMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        add = findViewById(R.id.SendButton);
        YourName = findViewById(R.id.YourName);
        YourEmail = findViewById(R.id.YourEmail);
        YouWantToTalkAbout = findViewById(R.id.YouWantToTalkAbout);
        YourMessage = findViewById(R.id.YourMessage);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yourName = YourName.getText().toString();
                String yourEmail = YourEmail.getText().toString();
                String youWantToTalkAbout = YouWantToTalkAbout.getText().toString();
                String yourMessage = YourMessage.getText().toString();


                if (yourName.isEmpty() || yourEmail.isEmpty() || youWantToTalkAbout.isEmpty() || yourMessage.isEmpty()) {
                    Toast.makeText(contact_us.this, "Empty input fields not allowed", Toast.LENGTH_SHORT).show();
                }
                else{
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("yourName", yourName);
                    map.put("yourEmail", yourEmail);
                    map.put("youWantToTalkAbout", youWantToTalkAbout);
                    map.put("yourMessage", yourMessage);

                    FirebaseDatabase.getInstance().getReference().child("honeyBeeDB").child("Contact_us").push().updateChildren(map);
                    Toast.makeText(contact_us.this, "Contact added successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}