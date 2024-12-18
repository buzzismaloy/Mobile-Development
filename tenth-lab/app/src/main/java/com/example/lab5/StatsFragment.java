package com.example.lab5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class StatsFragment extends Fragment {

    private TextView correctAnswersView, incorrectAnswersView, testsCompletedView;
    private Button shareButton, retryButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Связываем фрагмент с макетом
        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        // Получение элементов интерфейса
        correctAnswersView = view.findViewById(R.id.correct_answers);
        incorrectAnswersView = view.findViewById(R.id.incorrect_answers);
        testsCompletedView = view.findViewById(R.id.tests_completed);
        shareButton = view.findViewById(R.id.share_button);
        retryButton = view.findViewById(R.id.retry_button);

        // Получение статистики из аргументов фрагмента или SharedPreferences
        SharedPreferences prefs = requireActivity().getSharedPreferences("quiz_prefs", requireActivity().MODE_PRIVATE);
        int correctAnswers = getArguments() != null ? getArguments().getInt("CORRECT_ANSWERS", 0) : 0;
        int incorrectAnswers = getArguments() != null ? getArguments().getInt("INCORRECT_ANSWERS", 0) : 0;
        int testsCompleted = prefs.getInt("TESTS_COMPLETED", 0);

        // Установка значений статистики
        correctAnswersView.setText("Overall correct answers: " + correctAnswers);
        incorrectAnswersView.setText("Overall incorrect answers: " + incorrectAnswers);
        testsCompletedView.setText("Passed the tests: " + testsCompleted);

        // Кнопка для отправки статистики
        shareButton.setOnClickListener(v -> shareStatistics(correctAnswers, incorrectAnswers, testsCompleted));

        retryButton.setOnClickListener(v -> retryQuiz());

        return view;
    }

    private void retryQuiz() {
        Intent mainIntent = new Intent(getActivity(), QuestionActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mainIntent);
        requireActivity().finish(); // Закрыть текущую активность
    }

    private void shareStatistics(int correct, int incorrect, int tests) {
        String stats = "Correct: " + correct + ", Incorrect: " + incorrect + ", Tests passed: " + tests;
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, stats);
        startActivity(Intent.createChooser(shareIntent, "Share stat"));
    }



    public void updateStatistics(int trueAnswers, int incorrectAnswers) {
        if (correctAnswersView != null) {
            correctAnswersView.setText("Overall correct answers: " + trueAnswers);
        }
        if (incorrectAnswersView != null) {
            incorrectAnswersView.setText("Overall incorrect answers: " + incorrectAnswers);
        }
    }
}
