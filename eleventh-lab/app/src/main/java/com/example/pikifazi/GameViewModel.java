package com.example.pikifazi;

import androidx.lifecycle.ViewModel;
import androidx.databinding.ObservableField;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameViewModel extends ViewModel {
    private String secretCode;
    private int attempts;


    public ObservableField<String> resultText = new ObservableField<>("");
    public ObservableField<String> historyText = new ObservableField<>("История попыток:");
    private final List<String> history;

    public GameViewModel() {
        history = new ArrayList<>();
        resetGame();
    }



    public void resetGame() {
        secretCode = generateRandomCode();
        attempts = 0;
        history.clear();
        resultText.set("");
        historyText.set("История попыток:");
    }

    public String generateRandomCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        while (code.length() < 4) {
            int digit = random.nextInt(10); // [0-9]
            if (!code.toString().contains(String.valueOf(digit))) {
                code.append(digit);
            }
        }
        return code.toString();
    }

    public void checkAttempt(String input) {
        attempts++;
        int phases = 0;
        int pikes = 0;

        for (int i = 0; i < 4; i++) {
            char inputChar = input.charAt(i);
            if (secretCode.charAt(i) == inputChar) {
                phases++;
            } else if (secretCode.contains(String.valueOf(inputChar))) {
                pikes++;
            }
        }

        String result = input + " -> " + pikes + " пик, " + phases + " фаз";
        history.add(result);
        updateHistory();
        resultText.set(result);

        if (isWin(input)) {
            resultText.set("Поздравляем! Вы угадали: " + input);
        } else if (isGameOver()) {
            resultText.set("Вы проиграли. Попытки закончились.");
        }
    }

    private void updateHistory() {
        StringBuilder historyTextBuilder = new StringBuilder("История попыток:\n");
        for (String attempt : history) {
            historyTextBuilder.append(attempt).append("\n");
        }
        historyText.set(historyTextBuilder.toString());
    }

    public boolean isGameOver() {
        return attempts >= 15;
    }

    public boolean isWin(String input) {
        return secretCode.equals(input);
    }

    public String getSecretCode() {
        return secretCode;
    }
}
