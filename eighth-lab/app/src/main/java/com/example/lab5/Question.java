package com.example.lab5;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    private String questionText;
    private String[] options;  // Для вопросов с вариантами ответа
    private String[] correctAnswers;  // Для нескольких правильных вариантов
    private String correctAnswer;  // Для одного правильного варианта
    private QuestionType questionType;

    // Конструктор для вопросов с одним или несколькими вариантами ответа
    public Question(String questionText, String[] options, String[] correctAnswers, QuestionType questionType) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswers = correctAnswers;
        this.questionType = questionType;
    }

    // Конструктор для вопросов со свободным ответом
    public Question(String questionText, String correctAnswer, QuestionType questionType) {
        this.questionText = questionText;
        this.correctAnswers = new String[]{correctAnswer};  // Инициализируем массив с одним правильным ответом
        this.questionType = questionType;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public String[] getCorrectAnswers() {
        return correctAnswers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }
}


