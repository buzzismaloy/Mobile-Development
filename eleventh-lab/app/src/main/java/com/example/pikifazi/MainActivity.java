package com.example.pikifazi;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.pikifazi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private GameViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // включение dataBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(GameViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);


        binding.submitButton.setOnClickListener(v -> handleAttempt());
        binding.endGameButton.setOnClickListener(v -> showAnswer());
    }



    private void handleAttempt() {
        String input = binding.inputSequence.getText().toString();
        if (input.length() != 4) {
            viewModel.resultText.set("Введите ровно 4 цифры!");
            return;
        }
        viewModel.checkAttempt(input);
    }

    private void showAnswer() {
        viewModel.resultText.set("Загаданная последовательность: " + viewModel.getSecretCode());
    }
}