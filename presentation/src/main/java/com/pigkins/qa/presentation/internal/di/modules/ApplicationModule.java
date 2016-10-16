package com.pigkins.qa.presentation.internal.di.modules;

import android.app.Application;
import android.content.Context;

import com.pigkins.qa.presentation.AndroidApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by qding on 10/15/16.
 */
@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides @Singleton Context provideApplicationContext() {
        return this.application;
    }
}
