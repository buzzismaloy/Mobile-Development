package com.example.kendoquizv11;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StatisticsActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "QuizStats";
    private static final String CORRECT_KEY = "correctAnswers";
    private static final String INCORRECT_KEY = "incorrectAnswers";
    private static final String TESTS_KEY = "completedTests";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_statistics);

        ImageView goBack = findViewById(R.id.imageArrow);
        goBack.setOnClickListener(v -> finish());

        Button btnFindOutMore = findViewById(R.id.btnFindOutMore);
        Button btnShare = findViewById(R.id.btnShare);
        Button btnClearStat = findViewById(R.id.btnClearStat);


        btnFindOutMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StatisticsActivity.this, LinksActivity.class));
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        TextView tvOverallCorrect = findViewById(R.id.tvOverallCorrect);
        TextView tvOverallIncorrect = findViewById(R.id.tvOverallIncorrect);
        TextView tvTotalTests = findViewById(R.id.tvTotalTests);

        // Retrieve data from SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int correctAnswers = sharedPreferences.getInt(CORRECT_KEY, 0);
        int incorrectAnswers = sharedPreferences.getInt(INCORRECT_KEY, 0);
        int completedTests = sharedPreferences.getInt(TESTS_KEY, 0);

        // Set the data to the TextViews
        tvOverallCorrect.setText(String.valueOf(correctAnswers));
        tvOverallIncorrect.setText(String.valueOf(incorrectAnswers));
        tvTotalTests.setText(String.valueOf(completedTests));

        btnClearStat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearStats();
            }
        });
    }

    private void clearStats(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();  // Clear all data from SharedPreferences
        editor.apply();  // Apply changes asynchronously

        // Optionally, display a message to the user
        Toast.makeText(this, "Statistics cleared!", Toast.LENGTH_SHORT).show();

        // Update the UI or reset displayed statistics as needed
        updateStatisticsView();
    }

    private void updateStatisticsView(){
        // Reset UI elements to reflect cleared statistics
        TextView tvCorrect = findViewById(R.id.tvOverallCorrect);
        TextView tvIncorrect = findViewById(R.id.tvOverallIncorrect);
        TextView tvTests = findViewById(R.id.tvTotalTests);

        tvCorrect.setText("0");
        tvIncorrect.setText("0");
        tvTests.setText("0");
    }
}
