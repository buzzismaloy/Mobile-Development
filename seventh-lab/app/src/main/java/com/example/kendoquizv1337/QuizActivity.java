package com.example.kendoquizv1337;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class QuizActivity extends AppCompatActivity {
    private QuestionAnswers questionAnswers;

    private static final String PREFS_NAME = "QuizStats";
    private static final String CORRECT_KEY = "correctAnswers";
    private static final String INCORRECT_KEY = "incorrectAnswers";
    private static final String TESTS_KEY = "completedTests";
    private SharedPreferences sharedPreferences;

    //private ViewPager2 viewPager;

    private int totalCorrectAns, totalWrongAns, totalCompletedTests;
    private int questionIndex = 0, curCorrectAns = 0, curWrongAns = 0;

    private final Fragment[] questionFragments = {
            new RadioQuestionFragment(),
            new CheckBoxQuestionFragment(),
            new EditTextQuestionFragment()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        if (savedInstanceState == null){
            showQuestionFragment(questionIndex);
        }
        /*else {
            correctAns = savedInstanceState.getInt("correct");
            wrongAns = savedInstanceState.getInt("wrong");
            updateCounterView();
        }*/

        /*sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        totalCorrectAns = sharedPreferences.getInt(CORRECT_KEY, 0);
        totalWrongAns = sharedPreferences.getInt(INCORRECT_KEY, 0);
        totalCompletedTests = sharedPreferences.getInt(TESTS_KEY, 0);*/

        questionAnswers = new QuestionAnswers();

        ImageView goBack = findViewById(R.id.imageArrow1);
        goBack.setOnClickListener(v -> onBackPressed());
    }

    public void nextQuestion() {
        if (questionIndex < questionFragments.length - 1){
            ++questionIndex;
            showQuestionFragment(questionIndex);
        }
        else {

        }
    }

    private void showQuestionFragment(int index) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, questionFragments[index])
                .addToBackStack(null)
                .commit();
    }

    public void checkRadioGroup(RadioGroup radioGroup){

    }

    public void checkCheckBox(View view){

    }

    public void checkEditTextAnswer(String answer){

    }

    @Override
    public void onBackPressed() {
        if (questionIndex > 0){
            --questionIndex;
            super.onBackPressed();
        }
        else
            finish();
    }
}
