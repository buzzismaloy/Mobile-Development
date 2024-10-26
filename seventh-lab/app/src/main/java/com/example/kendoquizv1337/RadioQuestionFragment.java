package com.example.kendoquizv1337;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RadioQuestionFragment extends Fragment {
    private RadioGroup radioGroup;
    private QuizActivity quizActivity;
    private final static QuestionAnswers questionAnswers = new QuestionAnswers();
    private final static String[] OPTIONS = new String[] {
            "Bokuto",
            capitalizeFirstLetter(questionAnswers.getAnswer(questionAnswers.getQuestion(0))),
            "Shinken"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_radio_question, container, false);
        radioGroup = view.findViewById(R.id.radioGroup);
        TextView questionText = view.findViewById(R.id.questionText0);
        questionText.setText(questionAnswers.getQuestion(0));

        for (int i = 0; i < OPTIONS.length; ++i) {
            ((RadioButton) radioGroup.getChildAt(i)).setText(OPTIONS[i]);
        }

        Button nextButton = view.findViewById(R.id.btnNext0);
        nextButton.setOnClickListener(v -> {
            if (quizActivity != null) {
                quizActivity.checkRadioGroup(radioGroup);
                quizActivity.nextQuestion();
            }
        });

        return view;
    }

    private static String capitalizeFirstLetter(String word) {
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
