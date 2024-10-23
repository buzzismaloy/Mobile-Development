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

    private TextView tvCorrect;
    private TextView tvIncorrect;
    private TextView tvTests;


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
                shareStatistics();
            }
        });

        tvCorrect = findViewById(R.id.tvOverallCorrect);
        tvIncorrect = findViewById(R.id.tvOverallIncorrect);
        tvTests = findViewById(R.id.tvTotalTests);

        // Retrieve data from SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int correctAnswers = sharedPreferences.getInt(CORRECT_KEY, 0);
        int incorrectAnswers = sharedPreferences.getInt(INCORRECT_KEY, 0);
        int completedTests = sharedPreferences.getInt(TESTS_KEY, 0);

        // Set the data to the TextViews
        tvCorrect.setText(String.valueOf(correctAnswers));
        tvIncorrect.setText(String.valueOf(incorrectAnswers));
        tvTests.setText(String.valueOf(completedTests));

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
        tvCorrect.setText("0");
        tvIncorrect.setText("0");
        tvTests.setText("0");
    }

    private void shareStatistics() {
        String correct = tvCorrect.getText().toString();
        String incorrect = tvIncorrect.getText().toString();
        String totalTests = tvTests.getText().toString();

        // Create the message to share
        String shareMessage = "Quiz Statistics:\n"
                + "Correct Answers: " + correct + "\n"
                + "Incorrect Answers: " + incorrect + "\n"
                + "Total Tests Completed: " + totalTests;

        // Create an intent to share the message
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);

        // Start the share intent, showing options to the user
        startActivity(Intent.createChooser(shareIntent, "Share your statistics via:"));

    }
}
