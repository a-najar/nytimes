package com.geniusforapp.nytimes.application

import com.geniusforapp.nytimes.di.components.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/
class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<BaseApplication> {
        return DaggerApplicationComponent.builder().create(this)
    }


    override fun onCreate() {
        super.onCreate()
    }
}