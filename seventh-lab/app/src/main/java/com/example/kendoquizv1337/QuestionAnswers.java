package com.example.kendoquizv1337;

import java.util.HashMap;

public class QuestionAnswers {
    private static final String[] QUESTIONS = new String[] {
            "What is the name of bamboo sword used in Kendo",
            "Japanese wooden sword used for practicing kata",
            "How is called training in Japanese?",
            "What is shown in the picture"
    };
    private static final String[] ANSWERS = new String[] {
            "shinai",
            "bokken/bokuto",
            "keiko",
            "bogu"
    };
    private static final String ERROR_MSG = "Error!";

    private HashMap<String, String> generalQuestions;

    public QuestionAnswers() {
        generalQuestions = new HashMap<>();

        for(int i = 0; i < QUESTIONS.length; ++i)
            generalQuestions.put(QUESTIONS[i], ANSWERS[i]);

    }

    public String getQuestion(int numb) {
        if (numb > QUESTIONS.length || numb < 0)
            return ERROR_MSG;

        return QUESTIONS[numb];
    }

    public String getAnswer(String question){
        return generalQuestions.get(question);
    }

}
