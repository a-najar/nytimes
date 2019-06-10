package com.geniusforapp.nytimes.di.modules

import com.geniusforapp.nytimes.di.scopes.ActivityScope
import com.geniusforapp.nytimes.presentation.main.MainActivity
import com.geniusforapp.nytimes.presentation.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/

@Module
abstract class ActivityModule {


    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity
}