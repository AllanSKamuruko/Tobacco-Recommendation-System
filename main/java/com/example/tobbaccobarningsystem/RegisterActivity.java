package com.example.tobbaccobarningsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username,password;
    Button btnregister;
    RegistrationDBHelper DB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.et_username1);
        password = findViewById(R.id.et_password1);
        btnregister= findViewById(R.id.buttonLogin);
        DB = new RegistrationDBHelper(this);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String user =username.getText().toString();
            String pass= password.getText().toString();

            if(user.equals("") || pass.equals("")  ) {
                Toast.makeText(RegisterActivity.this,"please enter all fields",Toast.LENGTH_SHORT).show();
            }
            else{
                Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                if(checkuserpass==false){
                    Toast.makeText(RegisterActivity.this," log in successful",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),StageActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(RegisterActivity.this,"invalid credentials",Toast.LENGTH_SHORT).show();
                }
            }
            }
        });


    }
}