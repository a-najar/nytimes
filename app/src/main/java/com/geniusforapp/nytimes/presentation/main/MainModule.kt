package com.geniusforapp.nytimes.presentation.main

import com.geniusforapp.nytimes.presentation.main.data.repositories.ArticlesRepositoryImpl
import com.geniusforapp.nytimes.presentation.main.domain.repositories.ArticlesRepository
import dagger.Binds
import dagger.Module

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/
@Module
abstract class MainModule {


    @Binds
    abstract fun provideArticlesRepository(articlesRepositoryImpl: ArticlesRepositoryImpl): ArticlesRepository
}