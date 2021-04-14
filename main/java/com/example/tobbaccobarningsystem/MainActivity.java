

package com.example.tobbaccobarningsystem;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textViewRegister;
    EditText username;
    EditText password;
    Button buttonLogin;
    Button btnRegister;
    RegistrationDBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.et_username);
        password= findViewById(R.id.et_password);
        buttonLogin = findViewById(R.id.buttonLogin);
        btnRegister= findViewById(R.id.buttonRegister);
        DB = new RegistrationDBHelper(this);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(MainActivity.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else  {
                    Boolean checkuser = DB.checkusername(user);
                    if(checkuser==true){
                        Boolean insert = DB.insertData(user,pass);
                        if(insert==true){
                            Toast.makeText( MainActivity.this,"login successful",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),StageActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Login failed",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(MainActivity.this,"wrong details!",Toast.LENGTH_SHORT).show();
                    }
                }


            }});
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String users = username.getText().toString();
                String passs = password.getText().toString();

                if (users.equals("") || passs.equals("")) {
                    Toast.makeText(MainActivity.this, "Register your details", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "click register with empty fields", Toast.LENGTH_SHORT).show();

                }
            }
        });


        }}