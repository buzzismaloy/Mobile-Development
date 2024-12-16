package com.example.lab5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MultipleChoiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MultipleChoiceFragment extends Fragment {
    private TextView questionView;
    private LinearLayout optionsContainer;
    private Button submitButton;
    private Question question;

    public static MultipleChoiceFragment newInstance(Question question) {
        MultipleChoiceFragment fragment = new MultipleChoiceFragment();
        Bundle args = new Bundle();
        args.putSerializable("question", question);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_multiple_choice, container, false);

        questionView = view.findViewById(R.id.quiz_question);
        optionsContainer = view.findViewById(R.id.options_container);
        submitButton = view.findViewById(R.id.submit_answer_button);

        if (getArguments() != null) {
            question = (Question) getArguments().getSerializable("question");
            displayQuestion();
        }

        submitButton.setOnClickListener(v -> {
            List<String> selectedAnswers = getSelectedAnswers();
            String[] textArray = selectedAnswers.toArray(new String[0]);
            ((QuestionActivity) getActivity()).checkAnswer(textArray);
        });

        return view;
    }

    private void displayQuestion() {
        questionView.setText(question.getQuestionText());
        for (String option : question.getOptions()) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(option);
            optionsContainer.addView(checkBox);
        }
    }

    private List<String> getSelectedAnswers() {
        List<String> selectedAnswers = new ArrayList<>();
        // Проходим по всем дочерним элементам optionsContainer
        for (int i = 0; i < optionsContainer.getChildCount(); i++) {
            View child = optionsContainer.getChildAt(i);
            if (child instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) child;
                // Проверяем, отмечен ли чекбокс
                if (checkBox.isChecked()) {
                    // Добавляем текст чекбокса в список
                    selectedAnswers.add(checkBox.getText().toString());
                }
            }
        }
        return selectedAnswers;
    }
}
