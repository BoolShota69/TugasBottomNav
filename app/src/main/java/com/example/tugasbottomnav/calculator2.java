package com.example.tugasbottomnav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class calculator2 extends AppCompatActivity {

    TextView shapeText2, resultView2;
    EditText inputParam2_1, inputParam2_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator2);

        shapeText2 = findViewById(R.id.shapeName2);
        inputParam2_1 = findViewById(R.id.inputParam2_1);
        inputParam2_2 = findViewById(R.id.inputParam2_2);
        resultView2 = findViewById(R.id.resultView2);

        Intent intent = getIntent();
        String shape = intent.getStringExtra("shape2");
        String image = intent.getStringExtra("image2");

        shapeText2.setText(shape);

        Button button1 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateArea2(shape);
            }
        });
    }

    private void calculateArea2(String shape) {
        String inputUser1 = inputParam2_1.getText().toString();
        String inputUser2 = inputParam2_2.getText().toString();
        if (!inputUser1.isEmpty() && !inputUser2.isEmpty()) {
            double number1 = Double.parseDouble(inputUser1);
            double number2 = Double.parseDouble(inputUser2);
            double area = 0;
            switch (shape) {
                case "Triangle":
                    area = 0.5 * number1 * number2;
                    break;
                case "Cone":
                    area = 3.14 * number1 * number1 * (number2 / 3);
                    break;
            }
            String resultArea = String.format("%.2f", area);
            resultView2.setText("Area: " + resultArea);

        } else {
            resultView2.setText("Masukkan Angka");
        }
    }
}