package com.example.lab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private ImageView imageClass;
    private Button btn1;
    private Button btn2;

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
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inpEditText = editText.getText().toString();

                switch(inpEditText){
                    case "Imperium": {
                        String msg = getString(R.string.forEmperor);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                        imageClass = findViewById(R.id.imp_image);
                        if( imageClass.getVisibility() == View.VISIBLE){
                            imageClass.setVisibility(View.GONE);
                        }
                        else
                            imageClass.setVisibility(View.VISIBLE);
                        break;
                    }
                    case "Tau": {
                        String msg = getString(R.string.supremeGood);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                        imageClass = findViewById(R.id.tau_image);
                        if( imageClass.getVisibility() == View.VISIBLE){
                            imageClass.setVisibility(View.GONE);
                        }
                        else
                            imageClass.setVisibility(View.VISIBLE);
                        break;
                    }
                    case "Chaos": {
                        String msg = getString(R.string.chaosBattleCry);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                        imageClass = findViewById(R.id.chaos_image);
                        if( imageClass.getVisibility() == View.VISIBLE){
                            imageClass.setVisibility(View.GONE);
                        }
                        else
                            imageClass.setVisibility(View.VISIBLE);
                        break;
                    }
                    case "Eldars": {
                        String msg = getString(R.string.aeldari);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                        imageClass = findViewById(R.id.eldar_image);
                        if( imageClass.getVisibility() == View.VISIBLE){
                            imageClass.setVisibility(View.GONE);
                        }
                        else
                            imageClass.setVisibility(View.VISIBLE);
                        break;
                    }
                    default: {
                        String msg = getString(R.string.wrongInpMsg);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                        editText.setText("");
                    }
                }

                editText.setText("");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                String msg = getString(R.string.clearMsg);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

}