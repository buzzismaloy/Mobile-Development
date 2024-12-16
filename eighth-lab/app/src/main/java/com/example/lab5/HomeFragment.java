package com.example.lab5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Находим кнопку по её ID
        Button quizButton = view.findViewById(R.id.btnQuiz);
        Button quizFindOut = view.findViewById(R.id.btnFindOutMore);
        Button quizRules = view.findViewById(R.id.btnRules);

        // Устанавливаем обработчик нажатия
        quizButton.setOnClickListener(v -> {
            // Переход в QuestionActivity
            Intent intent = new Intent(getContext(), QuestionActivity.class);
            startActivity(intent);
        });

        quizFindOut.setOnClickListener(v -> findOutMore());

        quizRules.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), RulesActivity.class);
            startActivity(intent);
        });

        return view;
    }

    private void findOutMore() {
        Uri webpage = Uri.parse("https://www.kendo.or.jp/en/"); // Замените на нужный URL
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }
}
