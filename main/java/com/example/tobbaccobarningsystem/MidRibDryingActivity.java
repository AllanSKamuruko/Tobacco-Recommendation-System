package com.example.tobbaccobarningsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MidRibDryingActivity extends AppCompatActivity {
    Button buttonEnter2;
    EditText editTextTemp3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_rib_drying);
        buttonEnter2 = findViewById(R.id.buttonEnter3);
        editTextTemp3= findViewById(R.id.editTextTemp3);

        buttonEnter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mid();
            }
        });
    }
    public void Mid() {
        Double temperature = Double.parseDouble(editTextTemp3.getText().toString());
        if(temperature < 65){
            Toast.makeText(this,"Temp is low , turn heater on and increase to 65 degrees ",Toast.LENGTH_SHORT).show();
        }
        else if(temperature >=65 && temperature <=70){
            Toast.makeText(this,"Temp is ok, mantain the temperature! ",Toast.LENGTH_SHORT).show();
        }
        else if(temperature >70 && temperature <=100){
            Toast.makeText(this, " temperature is high reduce heat to 65 degrees!",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, " there is fire , shut down everything!",Toast.LENGTH_SHORT).show();
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