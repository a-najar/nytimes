package com.geniusforapp.nytimes.di.modules

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.geniusforapp.nytimes.application.BaseApplication
import com.geniusforapp.nytimes.shared.rx.AppSchedulerProvider
import com.geniusforapp.nytimes.shared.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/

@Module
class ApplicationModule {


    @Provides
    @Singleton
    fun provideContext(application: BaseApplication): Context {
        return application
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideLinearLayoutManager(context: Context): LinearLayoutManager {
        return LinearLayoutManager(context)
    }

    @Provides
    @Singleton
    fun provideSchedulerProvider(schedulerProvider: AppSchedulerProvider): SchedulerProvider {
        return schedulerProvider
    }

}