package com.example.lab;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textViewEq;
    private TextView textViewAns;

    private int b_ratio, c_ratio;
    private int x1 = 2, x2 = 3;

    private String equation, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText = findViewById(R.id.editText);
        textViewEq = findViewById(R.id.textView3);
        textViewAns = findViewById(R.id.textView4);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                String inpEditText = editText.getText().toString();
                try{
                    int parseInt = Integer.parseInt(inpEditText);
                    if (parseInt == x2) {
                        Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        generateCoefficients();
                        equation = String.format("x^2 %s%d * x %s%d = 0",
                                (b_ratio < 0 ? "- " : "+ "), Math.abs(b_ratio),
                                (c_ratio < 0 ? "- " : "+ "), Math.abs(c_ratio));
                        answer = String.format("x1 = %d%nx2 = ?", x1);
                        textViewEq.setText(equation);
                        textViewAns.setText(answer);
                        editText.setText("");
                    }
                    else {
                        editText.setText("");
                        Toast.makeText(MainActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (NumberFormatException error) {
                    Toast.makeText(MainActivity.this, "Incorrect input!", Toast.LENGTH_SHORT).show();
                }
                //textView1.setText(inpEditText);
                //Toast.makeText(MainActivity.this, "Wanna sleep", Toast.LENGTH_SHORT).show();
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                Toast.makeText(MainActivity.this, "Input field is cleared", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateCoefficients() {
        Random rand = new Random();
        int minRand = -9;
        int maxRand = 9;

        x1 = rand.nextInt((maxRand - minRand) + 1) - maxRand;
        x2 = rand.nextInt((maxRand - minRand) + 1) - maxRand;

        while (x1 == x2) {
            x2 = rand.nextInt((maxRand - minRand) + 1) - maxRand;
        }

        b_ratio = -(x1 + x2);
        c_ratio = x1 * x2;
    }
}