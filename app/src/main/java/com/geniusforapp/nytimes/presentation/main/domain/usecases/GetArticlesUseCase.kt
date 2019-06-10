package com.geniusforapp.nytimes.presentation.main.domain.usecases

import com.geniusforapp.nytimes.shared.data.remote.models.Article
import com.geniusforapp.nytimes.presentation.main.domain.repositories.ArticlesRepository
import com.geniusforapp.nytimes.shared.rx.SchedulerProvider
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/
class GetArticlesUseCase @Inject constructor(private val articlesRepository: ArticlesRepository, private val schedulerProvider: SchedulerProvider) {

    fun getArticles(timeLong: String): Flowable<List<Article>> {
        return articlesRepository
                .getArticles("viewed", timeLong)
                .compose(schedulerProvider.ioToMainFlowableScheduler())
    }
}