package com.geniusforapp.nytimes.presentation.main.data.repositories

import com.geniusforapp.nytimes.presentation.main.domain.repositories.ArticlesRepository
import com.geniusforapp.nytimes.shared.data.remote.APInterface
import com.geniusforapp.nytimes.shared.data.remote.models.Article
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/
class ArticlesRepositoryImpl @Inject constructor(private val apiInterface: APInterface) :
    ArticlesRepository {

    override fun getArticles(type: String, fromTime: String): Flowable<List<Article>> =
        apiInterface.getPoplarArticles(type, fromTime).map { it.results }
}
