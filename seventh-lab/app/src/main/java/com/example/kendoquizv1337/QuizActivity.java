package com.example.kendoquizv1337;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class QuizActivity extends AppCompatActivity {
    private final QuestionAnswers questionAnswers = new QuestionAnswers();
    private TextView counterTextView;

    private static final String PREFS_NAME = "QuizStats";
    private static final String CORRECT_KEY = "correctAnswers";
    private static final String INCORRECT_KEY = "incorrectAnswers";
    private static final String TESTS_KEY = "completedTests";
    private SharedPreferences sharedPreferences;

    //private ViewPager2 viewPager;

    private int totalCorrectAns, totalWrongAns, totalCompletedTests;
    private int questionIndex = 0, curCorrectAns = 0, curWrongAns = 0, completedTests = 0;

    private final Fragment[] questionFragments = {
            new RadioQuestionFragment(),
            new CheckBoxQuestionFragment(),
            new EditTextQuestionFragment(),
            new PictureQuestionFragment(),
            new RestartFragment()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        if (savedInstanceState == null){
            showQuestionFragment(questionIndex);
        }
        else {
            curCorrectAns = savedInstanceState.getInt("correct");
            curWrongAns = savedInstanceState.getInt("wrong");
            updateCounterView();
        }

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        totalCorrectAns = sharedPreferences.getInt(CORRECT_KEY, 0);
        totalWrongAns = sharedPreferences.getInt(INCORRECT_KEY, 0);
        totalCompletedTests = sharedPreferences.getInt(TESTS_KEY, 0);

        counterTextView = findViewById(R.id.counterTextView);
        ImageView goBack = findViewById(R.id.imageArrow1);
        goBack.setOnClickListener(v -> onBackPressed());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("correct", curCorrectAns);
        outState.putInt("wrong", curWrongAns);
    }

    // Восстановление данных
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        curCorrectAns = savedInstanceState.getInt("correct");
        curWrongAns = savedInstanceState.getInt("wrong");
        updateCounterView();
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        totalCorrectAns += curCorrectAns;
        totalWrongAns += curWrongAns;
        totalCompletedTests += completedTests;
        editor.putInt(CORRECT_KEY, totalCorrectAns);
        editor.putInt(INCORRECT_KEY, totalWrongAns);
        editor.putInt(TESTS_KEY, totalCompletedTests);
        editor.apply();
    }

    public void nextQuestion() {
        if (questionIndex < questionFragments.length - 1){
            ++questionIndex;
            showQuestionFragment(questionIndex);
        }
        else {
            completedTests++;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            totalCorrectAns += curCorrectAns;
            totalWrongAns += curWrongAns;
            totalCompletedTests += completedTests;
            editor.putInt(CORRECT_KEY, totalCorrectAns);
            editor.putInt(INCORRECT_KEY, totalWrongAns);
            editor.putInt(TESTS_KEY, totalCompletedTests);
            editor.apply();
            questionIndex = 0;
            completedTests = 0;
            curCorrectAns = 0;
            curWrongAns = 0;
            updateCounterView();
            showQuestionFragment(questionIndex);
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
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == R.id.option2) {
            curCorrectAns++;
            Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        }
        else {
            curWrongAns++;
            Toast.makeText(QuizActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
        updateCounterView();
    }

    public void checkCheckBox(View view){
        CheckBox checkBox1 = view.findViewById(R.id.checkbox1);
        CheckBox checkBox2 = view.findViewById(R.id.checkbox2);
        CheckBox checkBox3 = view.findViewById(R.id.checkbox3);
        CheckBox checkBox4 = view.findViewById(R.id.checkbox4);

        boolean isCheckBox1Checked = checkBox1.isChecked();
        boolean isCheckBox2Checked = checkBox2.isChecked();
        boolean isCheckBox3Checked = checkBox3.isChecked();
        boolean isCheckBox4Checked = checkBox4.isChecked();

        if (isCheckBox1Checked && isCheckBox3Checked && !isCheckBox2Checked && !isCheckBox4Checked) {
            curCorrectAns++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            curWrongAns++;
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
        }
        updateCounterView();
    }

    public void checkEditTextAnswer(String answer){
        if (answer.equals(questionAnswers.getAnswer(questionAnswers.getQuestion(questionIndex)).toLowerCase())) {
            curCorrectAns++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        }
        else {
            curWrongAns++;
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
        }
        updateCounterView();
    }

    private void updateCounterView(){
        String msg = "Correct: " + curCorrectAns + "  Incorrect: " + curWrongAns;
        counterTextView.setText(msg);
    }

    @Override
    public void onBackPressed() {
        if (questionIndex > 0 && questionIndex != questionFragments.length - 1){
            --questionIndex;
            super.onBackPressed();
        }
        else{
            if(curWrongAns + curCorrectAns == questionFragments.length)
                ++completedTests;
            finish();
        }

    }
}
