package com.example.kendoquizv1337;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EditTextQuestionFragment extends Fragment {
    private QuizActivity quizActivity;
    private EditText answerEditText;
    private static final QuestionAnswers questionAnswers = new QuestionAnswers();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_text_question, container, false);
        answerEditText = view.findViewById(R.id.answerEditText0);
        TextView questionText = view.findViewById(R.id.questionText2);
        questionText.setText(questionAnswers.getQuestion(2));

        Button nextButton = view.findViewById(R.id.btnNext2);
        nextButton.setOnClickListener(v -> {
            if (quizActivity != null) {
                String answer = answerEditText.getText().toString().toLowerCase();
                quizActivity.checkEditTextAnswer(answer);
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
