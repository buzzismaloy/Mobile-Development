package com.example.kendoquizv1337;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_rules);

        ImageView goBack = findViewById(R.id.imageArrow0);
        goBack.setOnClickListener(v -> finish());
    }
}