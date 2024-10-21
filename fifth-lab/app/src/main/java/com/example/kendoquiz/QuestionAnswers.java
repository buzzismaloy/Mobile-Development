package com.example.kendoquiz;

import java.util.Arrays;

public class QuestionAnswers {
    private final String firstQuestion = "What is the name of bamboo sword used in Kendo";
    private final String secondQuestion = "Japanese wooden sword used for practicing kata";
    private final String thirdQuestion = "How is called training in Japanese?";
    private final String finalQuestion = "What is shown in the picture";
    private final String errorMsg = "Error!";


    /*public boolean checkFirstQuestion(String answer) {
        String firstAns = "Shinai";
        return answer.equals(firstAns);
    }

    public boolean checkSecondQuestion(String[] answer) {
        String[] secondAns = new String[] {"Bokuto", "Bokken"};

        if (answer.length != secondAns.length)
            return false;

        int correctAnswer = 0;
        for(int i = 0; i < secondAns.length; ++i){
            if (secondAns.)
        }

        return correctAnswer == secondAns.length;
    }*/

    public boolean checkThirdQuestion(String answer){
        String thirdAns = "keiko";
        return answer.equals(thirdAns);
    }

    public boolean checkFinalQuestion(String answer){
        String finalAns = "bogu";
        return answer.equals(finalAns);
    }

    public String getQuestion(int numb){
        switch (numb){
            case 0:
                return firstQuestion;
            case 1:
                return secondQuestion;
            case 2:
                return thirdQuestion;
            case 3:
                return finalQuestion;

            default:
                return errorMsg;
        }
    }
}
