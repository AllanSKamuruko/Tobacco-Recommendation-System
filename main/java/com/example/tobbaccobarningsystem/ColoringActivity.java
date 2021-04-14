package com.example.tobbaccobarningsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ColoringActivity extends AppCompatActivity {
    Button buttonEnter;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coloring);
        buttonEnter = (Button) findViewById(R.id.buttonEnter);
        editText = (EditText) findViewById(R.id.editTextTemp);



        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Col();
            }
        });

    }
    public void Col() {
        Double temperature = Double.parseDouble(editText.getText().toString());
        if(temperature < 30){
            Toast.makeText(this,"Temp is low , turn heater on and increase heat to 35 degrees!",Toast.LENGTH_SHORT).show();
        }
        else if(temperature >=30 && temperature<= 40){
            Toast.makeText(this,"Temp is ok, do nothing! ",Toast.LENGTH_SHORT).show();
        }
        else if(temperature > 40 && temperature<=100){
            Toast.makeText(this, " temperature is high reduce heat to 35 degrees!",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, " there is a fire, shut down everything",Toast.LENGTH_SHORT).show();
            try {
                Process proc = Runtime.getRuntime()
                        .exec(new String[]{ "su", "-c", "reboot -p" });
                proc.waitFor();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}