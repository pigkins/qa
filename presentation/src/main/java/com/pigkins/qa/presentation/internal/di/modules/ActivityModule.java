package com.pigkins.qa.presentation.internal.di.modules;

import android.app.Activity;

import com.pigkins.qa.presentation.internal.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by qding on 10/16/16.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides @PerActivity
    Activity activity() {
        return this.activity;
    }
}
