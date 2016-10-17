package com.pigkins.qa.presentation.internal.di.components;

import android.app.Activity;

import com.pigkins.qa.presentation.internal.di.PerActivity;
import com.pigkins.qa.presentation.internal.di.modules.ActivityModule;

import dagger.Component;

/**
 * Created by qding on 10/16/16.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
