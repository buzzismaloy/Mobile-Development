package com.example.lab5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FreeResponseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FreeResponseFragment extends Fragment {
    private TextView questionView;
    private EditText responseInput;
    private Button submitButton;
    private Question question;

    public static FreeResponseFragment newInstance(Question question) {
        FreeResponseFragment fragment = new FreeResponseFragment();
        Bundle args = new Bundle();
        args.putSerializable("question", question);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_free_response, container, false);

        questionView = view.findViewById(R.id.quiz_question);
        responseInput = view.findViewById(R.id.free_response_input);
        submitButton = view.findViewById(R.id.submit_answer_button);

        if (getArguments() != null) {
            question = (Question) getArguments().getSerializable("question");
            questionView.setText(question.getQuestionText());
        }

        submitButton.setOnClickListener(v -> {
            if (responseInput != null) {
                String[] textArray = new String[]{responseInput.getText().toString()};
                ((QuestionActivity) getActivity()).checkAnswer(textArray);
            } else {
                Log.e("FreeResponseFragment", "responseInput is null");
            }
        });

        return view;
    }
}
