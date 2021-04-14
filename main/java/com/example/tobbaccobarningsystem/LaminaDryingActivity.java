package com.example.tobbaccobarningsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LaminaDryingActivity extends AppCompatActivity {
    EditText editText5;
    Button button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamina_drying);
        editText5 = findViewById(R.id.editTextTemp2);
        button5 = findViewById(R.id.buttonEnter2);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lam();
            }
        });
    }
    public void Lam() {
        Double temperature = Double.parseDouble(editText5.getText().toString());
        if(temperature < 40){
            Toast.makeText(this,"Temp is low , turn heater on and increase to 45 degrees ",Toast.LENGTH_LONG).show();
        }
        else if(temperature >=40 && temperature <=50){
            Toast.makeText(this,"Temp is ok, mantain the temperature! ",Toast.LENGTH_LONG).show();
        }
        else if(temperature >50 && temperature <=100){
            Toast.makeText(this, " temperature is high reduce heat to 45 degrees!",Toast.LENGTH_LONG).show();
        }
        else  {
            Toast.makeText(this, " there is fire , shut down everything!",Toast.LENGTH_LONG).show();
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