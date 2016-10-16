package com.pigkins.qa.presentation.internal.di.components;

import android.content.Context;

import com.pigkins.qa.presentation.internal.di.modules.ApplicationModule;
import com.pigkins.qa.presentation.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();
}
