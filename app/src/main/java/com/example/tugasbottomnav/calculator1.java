package com.example.tugasbottomnav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class calculator1 extends AppCompatActivity {

    TextView shapeText1, resultView1;
    EditText inputParam1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator1);

        shapeText1 = findViewById(R.id.shapeName1);
        inputParam1 = findViewById(R.id.inputParam1);
        resultView1 = findViewById(R.id.resultView1);

        Intent intent = getIntent();
        String shape = intent.getStringExtra("shape1");
        String image = intent.getStringExtra("image1");

        shapeText1.setText(shape);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateArea1(shape);
            }
        });
    }

    private void calculateArea1(String shape) {
        String inputUser = inputParam1.getText().toString();
        if (!inputUser.isEmpty()) {
            double number = Double.parseDouble(inputUser);
            double area = 0;
            switch (shape) {
                case "Square":
                    area = number * number;
                    break;
                case "Circle":
                    area = 3.14 * number * number;
                    break;
                case "Cube":
                    area = number * number * number;
                    break;
                case "Sphere":
                    area = ((double) 4 / 3) * 3.14 * number * number * number;
                    break;
            }
            String resultArea = String.format("%.2f", area);
            resultView1.setText("Area: " + resultArea);

        } else {
            resultView1.setText("Masukkan Angka");
        }
    }
}