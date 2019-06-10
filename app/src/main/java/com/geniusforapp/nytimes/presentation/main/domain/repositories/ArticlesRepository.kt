package com.geniusforapp.nytimes.presentation.main.domain.repositories

import com.geniusforapp.nytimes.shared.data.remote.models.Article
import io.reactivex.Flowable

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/
interface ArticlesRepository {

    fun getArticles(type: String, fromTime: String): Flowable<List<Article>>
}