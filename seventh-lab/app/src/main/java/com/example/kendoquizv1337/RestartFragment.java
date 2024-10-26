package com.example.kendoquizv1337;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class RestartFragment extends Fragment {
    private QuizActivity quizActivity;
    private Button btnRestart;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restart, container, false);

        Button btnRestart = view.findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(v -> {
            if (quizActivity != null) {
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
