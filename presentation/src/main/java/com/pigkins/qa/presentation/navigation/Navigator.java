package com.pigkins.qa.presentation.navigation;

import android.content.Context;
import android.content.Intent;

import com.pigkins.qa.presentation.view.activity.QuestionListActivity;
import com.pigkins.qa.presentation.view.activity.WeightListActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by qding on 10/15/16.
 */
@Singleton
public class Navigator {
    @Inject
    public Navigator() {

    }

    public void navigateToQAList(Context context) {
        if (context != null) {
            Intent intent = QuestionListActivity.getCallingIntent(context);
            context.startActivity(intent);
        }
    }

    public void navigateToWeightList(Context context) {
        if (context != null) {
            Intent intent = WeightListActivity.getCallingIntent(context);
            context.startActivity(intent);
        }
    }
}
