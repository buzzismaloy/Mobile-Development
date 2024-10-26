package com.example.kendoquizv1337;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Arrays;

public class CheckBoxQuestionFragment extends Fragment {
    private QuizActivity quizActivity;
    private static final QuestionAnswers questionAnswers = new QuestionAnswers();
    private static final String[] ANSWERS =
            questionAnswers.getAnswer(questionAnswers.getQuestion(1)).split("/");

    private static final String[] OPTIONS = new String[] {
             "Tachi", "Iaito"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_checkbox_question, container, false);
        TextView questionText = view.findViewById(R.id.questionText1);
        questionText.setText(questionAnswers.getQuestion(1));

        changeCheckBoxText(view);

        Button nextButton = view.findViewById(R.id.btnNext1);
        nextButton.setOnClickListener(v -> {
            if (quizActivity != null){
                quizActivity.checkCheckBox(view);
                quizActivity.nextQuestion();
            }
        });

        return view;
    }

    private void changeCheckBoxText(View view){
        String firstAnswer = capitalizeFirstLetter(ANSWERS[0]);
        String secondAnswer = capitalizeFirstLetter(ANSWERS[1]);
        ((CheckBox) view.findViewById(R.id.checkbox1)).setText(firstAnswer);
        ((CheckBox) view.findViewById(R.id.checkbox2)).setText(OPTIONS[0]);
        ((CheckBox) view.findViewById(R.id.checkbox3)).setText(secondAnswer);
        ((CheckBox) view.findViewById(R.id.checkbox4)).setText(OPTIONS[1]);
    }

    private String capitalizeFirstLetter(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof QuizActivity)
            quizActivity = (QuizActivity) context;

    }

}
