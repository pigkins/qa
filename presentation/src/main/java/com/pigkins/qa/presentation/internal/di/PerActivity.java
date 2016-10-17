package com.pigkins.qa.presentation.internal.di;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.inject.Scope;

/**
 * Created by qding on 10/16/16.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity { }
