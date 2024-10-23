package com.example.kendoquizv11;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        ImageView goBack = findViewById(R.id.imageArrow);
        goBack.setOnClickListener(v -> finish());
    }
}
