package com.example.lab5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    private List<Question> questionsList;
    private int currentQuestionIndex = 0;
    private int trueAnswers = 0;
    private int incorrectAnswers = 0;
    private Question currentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        adjustLayoutWeight();

        // Инициализация вопросов
        initQuestions();

        if (savedInstanceState != null) {
            currentQuestionIndex = savedInstanceState.getInt("CURRENT_QUESTION_INDEX", 0);
        } else {
            currentQuestionIndex = 0; // Устанавливаем начальный индекс, если состояние не сохранено
        }

        if (currentQuestionIndex < questionsList.size() - 1) {
            currentQuestion = questionsList.get(currentQuestionIndex);
            Log.d("QuestionActivity", "Showing question: " + currentQuestion.getQuestionText());
            showQuestionFragment(currentQuestion);
        }

        Log.d("QuestionActivity", "onCreate: currentQuestionIndex = " + currentQuestionIndex + ", totalQuestions = " + questionsList.size());
    }

    private void adjustLayoutWeight() {
        // Получаем контейнер для фрагмента статистики
        FrameLayout statsContainer = findViewById(R.id.stats_fragment_container);

        // Проверяем ориентацию
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Устанавливаем вес 1 при горизонтальной ориентации
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) statsContainer.getLayoutParams();
            params.weight = 1;
            statsContainer.setLayoutParams(params);
            openStatsActivity(R.id.stats_fragment_container);
        } else {
            // Устанавливаем вес 0 при вертикальной ориентации
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) statsContainer.getLayoutParams();
            params.weight = 0;
            statsContainer.setLayoutParams(params);
        }
    }

    private void initQuestions() {
        questionsList = new ArrayList<>();

        // Вопрос с одним вариантом ответа
        questionsList.add(new Question(
                "What is the name of the bamboo sword used in Kendo",
                new String[]{"shinai", "bokuto", "shinken", "tsurugi"},
                new String[]{"shinai"},  // Один правильный ответ
                QuestionType.SINGLE_CHOICE
        ));

        // Вопрос с несколькими вариантами ответа
        questionsList.add(new Question(
                "Japanese wooden sword used for practicing Kendo kata",
                new String[]{"bokuto", "iaito", "tachi", "bokken"},
                new String[]{"bokuto", "bokken"},  // Несколько правильных ответов
                QuestionType.MULTIPLE_CHOICE
        ));

        // Вопрос со свободным ответом
        questionsList.add(new Question(
                "How is called training in Japanese?",
                "keiko",  // Правильный ответ
                QuestionType.FREE_RESPONSE
        ));

        // Вопрос с изображением и свободным ответом
        questionsList.add(new Question(
                "What is shown in the picture?",
                "bogu",  // Правильный ответ
                QuestionType.IMAGE
        ));
    }

    public void checkAnswer(String[] userAnswers) {
        if (currentQuestion == null) return;

        // Проверяем, что массив userAnswers не равен null или пустой
        if (userAnswers == null || userAnswers.length == 0) {
            Toast.makeText(this, "User Error!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Проверяем правильность ответа в зависимости от типа вопроса
        boolean isCorrect = false;

        // Проверяем, что correctAnswers не равен null
        String[] correctAnswers = currentQuestion.getCorrectAnswers();
        if (correctAnswers == null) {
            Toast.makeText(this, "Correct Answers Error!", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (currentQuestion.getQuestionType()) {
            case SINGLE_CHOICE:
                // Для одного правильного ответа
                isCorrect = userAnswers.length == 1 && userAnswers[0].equalsIgnoreCase(correctAnswers[0]);
                break;
            case MULTIPLE_CHOICE:
                // Для нескольких правильных ответов
                List<String> correctAnswersList = Arrays.asList(correctAnswers);
                isCorrect = Arrays.asList(userAnswers).containsAll(correctAnswersList)
                        && correctAnswersList.containsAll(Arrays.asList(userAnswers));
                break;
            case FREE_RESPONSE:
            case IMAGE:
                // Для ответа с текстом или изображением (один правильный ответ)
                isCorrect = userAnswers.length == 1 && userAnswers[0].equalsIgnoreCase(correctAnswers[0]);
                break;
            default:
                isCorrect = false;
                break;
        }

        // Обновляем счетчики правильных и неправильных ответов
        if (isCorrect) {
            trueAnswers++;
        } else {
            incorrectAnswers++;
        }

        // Логируем результат
        Log.d("QuestionActivity", "Question: " + currentQuestion.getQuestionText() +
                " User answer: " + Arrays.toString(userAnswers) +
                " Is correct: " + isCorrect);

        // Переход к следующему вопросу
        showNextQuestion();
    }


    public void showNextQuestion() {
        Log.d("QuestionActivity", "showNextQuestion: currentQuestionIndex = " + currentQuestionIndex);

        if (currentQuestionIndex < questionsList.size() - 1) {
            Log.d("QuestionActivity", "Showing question: " + currentQuestion.getQuestionText());
            currentQuestionIndex++;
            currentQuestion = questionsList.get(currentQuestionIndex);
            showQuestionFragment(currentQuestion);
        } else {
            Log.d("QuestionActivity", "End of questions. Showing results.");
            showFinalResults();
        }

        updateStatsFragment();
    }


    private void updateStatsFragment() {
        StatsFragment statsFragment = (StatsFragment) getSupportFragmentManager().findFragmentById(R.id.stats_fragment_container);
        if (statsFragment != null) {
            statsFragment.updateStatistics(trueAnswers, incorrectAnswers);
        } else {
            // Если фрагмент не существует, можно заново создать его
            openStatsActivity(R.id.stats_fragment_container);
        }
    }


    private void showQuestionFragment(Question question) {
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putSerializable("question", question);

        switch (question.getQuestionType()) {
            case SINGLE_CHOICE:
                fragment = new SingleChoiceFragment();
                break;
            case MULTIPLE_CHOICE:
                fragment = new MultipleChoiceFragment();
                break;
            case FREE_RESPONSE:
                fragment = new FreeResponseFragment();
                break;
            case IMAGE:
                fragment = new ImageQuestionFragment();
                break;
        }

        if (fragment != null) {
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    private void showFinalResults() {
        SharedPreferences prefs = getSharedPreferences("quiz_prefs", MODE_PRIVATE);
        int completedTests = prefs.getInt("TESTS_COMPLETED", 0);
        completedTests++;
        prefs.edit().putInt("TESTS_COMPLETED", completedTests).apply();

        Log.d("QuestionActivity", "Tests completed: " + completedTests);
        openStatsActivity(R.id.fragment_container);
    }

    private void openStatsActivity(int container) {
        StatsFragment statsFragment = new StatsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("CORRECT_ANSWERS", trueAnswers);
        bundle.putInt("INCORRECT_ANSWERS", incorrectAnswers);
        statsFragment.setArguments(bundle);

        // Добавляем фрагмент в контейнер
        getSupportFragmentManager()
                .beginTransaction()
                .replace(container, statsFragment)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("TRUE_ANSWERS", trueAnswers);
        outState.putInt("INCORRECT_ANSWERS", incorrectAnswers);
        outState.putInt("CURRENT_QUESTION_INDEX", currentQuestionIndex);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        trueAnswers = savedInstanceState.getInt("TRUE_ANSWERS");
        incorrectAnswers = savedInstanceState.getInt("INCORRECT_ANSWERS");
        currentQuestionIndex = savedInstanceState.getInt("CURRENT_QUESTION_INDEX");

        Log.d("QuestionActivity", "onRestoreInstanceState: currentQuestionIndex = " + currentQuestionIndex);

        updateStatsFragment();
    }

}
