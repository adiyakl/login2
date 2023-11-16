package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registar1 extends AppCompatActivity {
    Switch swi1;
    TextInputEditText c_firstName;
    TextInputEditText c_lastName;
    TextInputEditText c_phone;
    TextInputEditText c_userName;
    TextInputEditText c_password;
    private FirebaseAuth auth;
    private DatabaseReference mDatabase;
    Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar1);
        c_firstName = findViewById(R.id.fname);
        c_lastName = findViewById(R.id.lname);
        c_phone = findViewById(R.id.phone);
        c_userName = findViewById(R.id.user);
        c_password = findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        button = findViewById(R.id.reg_Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c_firstName.getText() == null ||c_lastName.getText() == null ||c_phone.getText() == null ||c_userName.getText() == null ||c_password.getText() == null )
                {
                    Toast.makeText(registar1.this,"please make sure all the fields are full", Toast.LENGTH_SHORT).show();
                    return;
                }

                String cfname = String.valueOf(c_firstName.getText());//אם הבלוק ריק יצור שגיאה
                String clname = String.valueOf(c_lastName.getText());
                String cphone = String.valueOf(c_phone.getText());
                String cuser = String.valueOf(c_userName.getText());
                String cpass = String.valueOf(c_password.getText());
                if(cpass.isEmpty()||cuser.isEmpty()||cphone.isEmpty()||clname.isEmpty()||cfname.isEmpty()){ //בדיקת קלט
                    Toast.makeText(registar1.this,"please make sure all the fields are full", Toast.LENGTH_SHORT).show();
                    return;
                }
                User user = new User(cfname,clname,cpass,cphone,cuser);
                mDatabase.child("users").child(cuser).setValue(user);//Zשם בבסיס נתונים ילד


//                auth.createUserWithEmailAndPassword(null, cpass)
//                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                               if(task.isSuccessful()){
//                                    User user = new User(cfname,clname,cpass,cphone,cuser);
//                                    FirebaseDatabase.getInstance().getReference("Users")
//                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                @Override
//                                                public void onComplete(@NonNull Task<Void> task) {
//                                                    if (task.isSuccessful()){
//                                                        Toast.makeText(registar1.this, "user registerd successfully",Toast.LENGTH_LONG).show();
//
//                                                    }
//                                                    else{
//                                                        Toast.makeText(registar1.this, "user faild to registerd ",Toast.LENGTH_LONG).show();
//
//                                                    }
//                                                }
//                                            });
//
//                               }
//                               else{
//                                   Toast.makeText(registar1.this, "user faild to registerd ",Toast.LENGTH_LONG).show();
//
//                               }
//                            }
//                        });
            }

        });
        swi1 = findViewById(R.id.switch1);
        swi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), login1.class);
                startActivity(intent);
                finish();

            }
        });
    }
}