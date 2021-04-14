
package com.example.tobbaccobarningsystem;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;

        import androidx.appcompat.app.AppCompatActivity;


        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.TextView;

public class StageActivity extends AppCompatActivity {

    TextView textView1;
    Button buttonStage1;
    Button buttonStage2;
    Button buttonStage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);

        textView1 = findViewById(R.id.selectstages);
        buttonStage1 = findViewById(R.id.buttonStage1);
        buttonStage2 = findViewById(R.id.buttonStage2);
        buttonStage3 = findViewById(R.id.buttonStage3);



        buttonStage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColoringActivity();
            }
        });
        buttonStage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLaminaDryingActivity();
            }
        });
        buttonStage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMidRibDrying();
            }
        });


    }

    public void openColoringActivity() {
        Intent intent = new Intent(this, ColoringActivity.class);
        startActivity(intent);


    }

    public void openLaminaDryingActivity() {
        Intent intent = new Intent(this, LaminaDryingActivity.class);
        startActivity(intent);


    }

    public void openMidRibDrying() {
        Intent intent = new Intent(this, MidRibDryingActivity.class);
        startActivity(intent);


    }
}