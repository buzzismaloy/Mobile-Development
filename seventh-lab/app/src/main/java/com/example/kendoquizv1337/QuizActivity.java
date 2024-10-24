package com.example.kendoquizv1337;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class QuizActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "QuizStats";
    private static final String CORRECT_KEY = "correctAnswers";
    private static final String INCORRECT_KEY = "incorrectAnswers";
    private static final String TESTS_KEY = "completedTests";

    private ViewPager2 viewPager;
    private SharedPreferences sharedPreferences;

    int totalCorrectAns, totalWrongAns, totalCompletedTests;

    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_quiz);

        ImageView goBack = findViewById(R.id.imageArrow1);
        goBack.setOnClickListener(v -> finish());
    }
}
