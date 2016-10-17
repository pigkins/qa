package com.pigkins.qa.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pigkins.qa.R;
import com.pigkins.qa.presentation.internal.di.HasComponent;
import com.pigkins.qa.presentation.internal.di.components.DaggerQuestionComponent;
import com.pigkins.qa.presentation.internal.di.components.QuestionComponent;
import com.pigkins.qa.presentation.model.QuestionModel;
import com.pigkins.qa.presentation.view.fragment.QuestionListFragment;

public class QuestionListActivity extends BaseActivity implements HasComponent<QuestionComponent>, QuestionListFragment.QuestionListListener {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, QuestionListActivity.class);
    }

    private QuestionComponent questionComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);
        this.initializeInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new QuestionListFragment());
        }
    }

    private void initializeInjector() {
        this.questionComponent = DaggerQuestionComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public QuestionComponent getComponent() {
        return questionComponent;
    }

    @Override
    public void onQuestionClicked(QuestionModel questionModel) {

    }
}
