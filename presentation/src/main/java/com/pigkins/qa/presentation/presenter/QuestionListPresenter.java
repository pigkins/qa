package com.pigkins.qa.presentation.presenter;

import android.support.annotation.NonNull;

import com.pigkins.qa.presentation.model.QuestionModel;
import com.pigkins.qa.presentation.view.QuestionListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.inject.Inject;

/**
 * Created by qding on 10/16/16.
 */
public class QuestionListPresenter implements Presenter {

    private QuestionListView questionListView;

    @Inject
    public QuestionListPresenter() {}

    public void setView (@NonNull QuestionListView view) {
        this.questionListView = view;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        this.questionListView = null;
    }

    public void onQuestionClicked(QuestionModel questionModel) {
        this.questionListView.viewQuestion(questionModel);
    }

    public void initialize() {
        // fake data
        final Collection<QuestionModel> questionModelCollection =
                new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            questionModelCollection.add(new QuestionModel(i, new Date(2016, 1, i), "asfsf"));
        }
        for (int i = 1; i < 28; i++) {
            questionModelCollection.add(new QuestionModel(i, new Date(2016, 2, i), "asfsafsf"));
        }
        questionListView.renderQuestionList(questionModelCollection);
    }
}
