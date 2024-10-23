package com.example.kendoquizv11;
import android.content.SharedPreferences;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    private final int MAX_COUNT_CLICKS = 3;
    QuestionAnswers questionAnswers;
    int countClicks = 0, correctAns = 0, wrongAns = 0, completedTests = 0;
    int totalCorrectAns = 0, totalWrongAns = 0, totalCompletedTests;

    private static final String PREFS_NAME = "QuizStats";
    private static final String CORRECT_KEY = "correctAnswers";
    private static final String INCORRECT_KEY = "incorrectAnswers";
    private static final String TESTS_KEY = "completedTests";
    SharedPreferences sharedPreferences;

    private RadioGroup radioGroup;
    //private RadioButton radioButton1, radioButton2, radioButton3;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    private EditText editTextAns, editTextAnsPic;
    private TextView textView3, counterTextView;
    private ImageView imageBogu;
    private LinearLayout checkBoxGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        questionAnswers = new QuestionAnswers();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        if (savedInstanceState != null) {
            correctAns = savedInstanceState.getInt("correct");
            wrongAns = savedInstanceState.getInt("wrong");
            updateCounterView();
        }

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        totalCorrectAns = sharedPreferences.getInt(CORRECT_KEY, 0);
        totalWrongAns = sharedPreferences.getInt(INCORRECT_KEY, 0);
        totalCompletedTests = sharedPreferences.getInt(TESTS_KEY, 0);

        radioGroup = findViewById(R.id.radioGroup);
        checkBoxGroup = findViewById(R.id.checkBoxGroup);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        /*radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);*/
        editTextAns = findViewById(R.id.exitTextAns);
        editTextAnsPic = findViewById(R.id.exitTextAnsPic);
        textView3 = findViewById(R.id.textView3);
        counterTextView = findViewById(R.id.counterTextView);
        imageBogu = findViewById(R.id.boguImage);

        ImageView goBack = findViewById(R.id.imageArrow);
        goBack.setOnClickListener(v -> finish());

        Button btnRestart = findViewById(R.id.btnRestart);
        Button btnCheck = findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(countClicks){
                    case 0: {
                        checkRadioGroup();
                        radioGroup.setVisibility(View.INVISIBLE);
                        checkBoxGroup.setVisibility(View.VISIBLE);
                        break;
                    }

                    case 1: {
                        checkCheckBox();
                        checkBoxGroup.setVisibility(View.INVISIBLE);
                        editTextAns.setVisibility(View.VISIBLE);
                        break;
                    }

                    case 2: {
                        String input = editTextAns.getText().toString().toLowerCase();
                        if (questionAnswers.checkThirdQuestion(input)){
                            correctAns++;
                            Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            wrongAns++;
                            Toast.makeText(QuizActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                        }
                        editTextAns.setVisibility(View.INVISIBLE);
                        editTextAnsPic.setVisibility(View.VISIBLE);
                        imageBogu.setVisibility(View.VISIBLE);
                        break;
                    }

                    case 3: {
                        String input = editTextAnsPic.getText().toString().toLowerCase();
                        if (questionAnswers.checkFinalQuestion(input)){
                            correctAns++;
                            Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            wrongAns++;
                            Toast.makeText(QuizActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                        }
                        editTextAnsPic.setVisibility(View.INVISIBLE);
                        imageBogu.setVisibility(View.INVISIBLE);
                        //radioGroup.setVisibility(View.VISIBLE);
                        break;
                    }
                }
                if (countClicks == MAX_COUNT_CLICKS) {
                    ++completedTests;
                    textView3.setText("To restart, press button below,\nTo go back tap on Arrow");
                    btnRestart.setVisibility(View.VISIBLE);
                    btnCheck.setEnabled(false);
                }
                else {
                    countClicks++;
                    String question = questionAnswers.getQuestion(countClicks);
                    textView3.setText(question);
                }
                updateCounterView();
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countClicks = 0;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                totalCorrectAns += correctAns;
                totalWrongAns += wrongAns;
                totalCompletedTests += completedTests;
                editor.putInt(CORRECT_KEY, totalCorrectAns);
                editor.putInt(INCORRECT_KEY, totalWrongAns);
                editor.putInt(TESTS_KEY, totalCompletedTests);
                editor.apply();
                correctAns = 0;
                wrongAns = 0;
                completedTests = 0;
                updateCounterView();
                radioGroup.setVisibility(View.VISIBLE);
                String question = questionAnswers.getQuestion(countClicks);
                textView3.setText(question);
                btnRestart.setVisibility(View.INVISIBLE);
                btnCheck.setEnabled(true);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("correct", correctAns);
        outState.putInt("wrong", wrongAns);
    }

    // Восстановление данных
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        correctAns = savedInstanceState.getInt("correct");
        wrongAns = savedInstanceState.getInt("wrong");
        updateCounterView();
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        totalCorrectAns += correctAns;
        totalWrongAns += wrongAns;
        totalCompletedTests += completedTests;
        editor.putInt(CORRECT_KEY, totalCorrectAns);
        editor.putInt(INCORRECT_KEY, totalWrongAns);
        editor.putInt(TESTS_KEY, totalCompletedTests);
        editor.apply();
    }

    private void updateCounterView(){
        String msg = "Correct: " + correctAns + "  Incorrect: " + wrongAns;
        counterTextView.setText(msg);
    }

    private void checkRadioGroup(){
        int selectedButtonId = radioGroup.getCheckedRadioButtonId();
        if (selectedButtonId == R.id.radioButton2){
            correctAns++;
            Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        }
        else {
            wrongAns++;
            Toast.makeText(QuizActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkCheckBox(){
        boolean isCheckBox1Checked = checkBox1.isChecked();
        boolean isCheckBox2Checked = checkBox2.isChecked();
        boolean isCheckBox3Checked = checkBox3.isChecked();
        boolean isCheckBox4Checked = checkBox4.isChecked();

        if (isCheckBox1Checked && isCheckBox3Checked && !isCheckBox2Checked && !isCheckBox4Checked) {
            correctAns++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            wrongAns++;
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
        }
    }

}
