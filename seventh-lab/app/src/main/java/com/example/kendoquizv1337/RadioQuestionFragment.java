package com.example.kendoquizv1337;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RadioQuestionFragment extends Fragment {
    private RadioGroup radioGroup;
    private QuizActivity quizActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_radio_question, container, false);
        radioGroup = view.findViewById(R.id.radioGroup);
        TextView textView = view.findViewById(R.id.questionText0);
        //textView.setText();

        Button nextButton = view.findViewById(R.id.btnNext);
        nextButton.setOnClickListener(v -> {
            if (quizActivity != null) {
                quizActivity.checkRadioGroup(radioGroup);
                quizActivity.nextQuestion();
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof QuizActivity)
            quizActivity = (QuizActivity) context;

    }

}
