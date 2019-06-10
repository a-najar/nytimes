package com.geniusforapp.nytimes.di.components

import com.geniusforapp.nytimes.application.BaseApplication
import com.geniusforapp.nytimes.di.modules.ActivityModule
import com.geniusforapp.nytimes.di.modules.ApplicationModule
import com.geniusforapp.nytimes.di.modules.NetworkModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/
@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            ApplicationModule::class,
            ActivityModule::class,
            NetworkModule::class
        ]
)
interface ApplicationComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BaseApplication>()
}