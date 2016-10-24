package com.pigkins.qa.presentation.presenter;

import android.content.Context;
import android.renderscript.ScriptGroup;
import android.support.annotation.NonNull;
import android.util.Log;

import com.pigkins.qa.R;
import com.pigkins.qa.presentation.model.QuestionModel;
import com.pigkins.qa.presentation.view.QuestionListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    public void initialize(Context context) {
        // fake data
        Collection<QuestionModel> questionModelCollection =
                new ArrayList<>();

        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.questions);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int count = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Log.d(this.getClass().getName(), "line = "+line);
                String[] tokens = line.split("\\|");
                Log.d(this.getClass().getName(), "tokens = " + tokens.length);
                questionModelCollection.add(new QuestionModel(++count, tokens[0], tokens[1], tokens[2]));

            }
        } catch (IOException e) {

        }
        questionListView.renderQuestionList(questionModelCollection);
    }
}
