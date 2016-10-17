package com.pigkins.qa.presentation.model;

import java.util.Date;

/**
 * Created by qding on 10/16/16.
 */
public class QuestionModel {
    private final int questionId;

    public QuestionModel(int questionId, Date date, String question) {
        this.questionId = questionId;
        this.date = date;
        this.question = question;
    }

    private String question;
    private Date date;

    public int getQuestionId() {
        return questionId;
    }

    public Date getDate() {
        return date;
    }

    public String getQuestion() {
        return question;
    }

    @Override public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("***** Question Model Details *****\n");
        stringBuilder.append("id=" + this.getQuestionId() + "\n");
        stringBuilder.append("date=" + this.getDate().toString() + "\n");
        stringBuilder.append("question=" + this.getQuestion() + "\n");
        stringBuilder.append("*******************************");

        return stringBuilder.toString();
    }
}
