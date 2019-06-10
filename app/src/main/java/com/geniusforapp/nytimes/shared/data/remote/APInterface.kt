package com.geniusforapp.nytimes.shared.data.remote

import com.geniusforapp.nytimes.shared.data.remote.models.Article
import com.geniusforapp.nytimes.shared.data.remote.models.Envelope
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/
interface APInterface {

    @GET(APIConstants.API_MOST_POP)
    fun getPoplarArticles(@Path("type") type: String, @Path("fromTime") formTime: String): Flowable<Envelope<List<Article>>>
}