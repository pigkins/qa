package com.pigkins.qa.presentation.model;

import java.util.Date;

/**
 * Created by qding on 10/16/16.
 */
public class QuestionModel {
    private final int questionId;

    public QuestionModel(int questionId, String month, String day, String question) {
        this.questionId = questionId;
        this.month = month;
        this.day = day;
        this.question = question;
    }

    private String question;
    private String month;
    private String day;

    public int getQuestionId() {
        return questionId;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getQuestion() {
        return question;
    }

    @Override public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("***** Question Model Details *****\n");
        stringBuilder.append("id=" + this.getQuestionId() + "\n");
        stringBuilder.append("date=" + this.getMonth() + " " + this.getDay() + "\n");
        stringBuilder.append("question=" + this.getQuestion() + "\n");
        stringBuilder.append("*******************************");

        return stringBuilder.toString();
    }
}
