package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class login1 extends AppCompatActivity {
    Switch swi1;
    TextInputEditText c_user;
    TextInputEditText c_password;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        c_user= findViewById(R.id.user);
        c_password = findViewById(R.id.password);
        button = findViewById(R.id.log_button);
        swi1 = (findViewById(R.id.switch1));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String cuser = String.valueOf(c_user.getText());
            String cpass = String.valueOf(c_password.getText());
                if(cpass.isEmpty()||cuser.isEmpty()){ //בדיקת קלט
                    Toast.makeText(login1.this,"please make sure all the fields are full", Toast.LENGTH_SHORT).show();
                }
            }
        });
        swi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), registar1.class);
                startActivity(intent);
                finish();
            }
        });


    }
}