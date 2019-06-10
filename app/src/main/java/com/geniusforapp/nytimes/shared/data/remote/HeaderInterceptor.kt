package com.geniusforapp.nytimes.shared.data.remote

import com.geniusforapp.nytimes.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/
class HeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
        val newRequestUrl = request.url().newBuilder()
        newRequestUrl.addQueryParameter(APIConstants.API_KEY, BuildConfig.API_KEY)
        newRequest.url(newRequestUrl.build())
        return chain.proceed(newRequest.build())
    }

}