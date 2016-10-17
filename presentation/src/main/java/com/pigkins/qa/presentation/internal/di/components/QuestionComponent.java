package com.pigkins.qa.presentation.internal.di.components;

import com.pigkins.qa.presentation.internal.di.PerActivity;
import com.pigkins.qa.presentation.internal.di.modules.ActivityModule;
import com.pigkins.qa.presentation.view.fragment.QuestionListFragment;

import dagger.Component;

/**
 * Created by qding on 10/16/16.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface QuestionComponent extends ActivityComponent{
    void inject(QuestionListFragment questionListFragment);
}
