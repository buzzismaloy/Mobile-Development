package com.example.kendoquizv11;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_rules);

        ImageView goBack = findViewById(R.id.imageArrow);
        goBack.setOnClickListener(v -> finish());
    }
}
