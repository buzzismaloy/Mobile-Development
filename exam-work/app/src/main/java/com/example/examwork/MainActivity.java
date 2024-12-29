package com.example.examwork;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.examwork.GridFragment;
import com.example.examwork.LinearFragment;
import com.example.examwork.StaggeredFragment;

public class MainActivity extends AppCompatActivity {

    private Button btnLinear, btnGrid, btnStaggered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLinear = findViewById(R.id.btnLinear);
        btnGrid = findViewById(R.id.btnGrid);
        btnStaggered = findViewById(R.id.btnStaggered);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, new LinearFragment())
                .commit();

        btnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new LinearFragment())
                        .commit();
            }
        });

        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new GridFragment())
                        .commit();
            }
        });

        btnStaggered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new StaggeredFragment())
                        .commit();
            }
        });
    }
}