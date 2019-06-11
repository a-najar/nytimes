package com.geniusforapp.nytimes.presentation.main.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geniusforapp.nytimes.presentation.main.domain.usecases.GetArticlesUseCase
import com.geniusforapp.nytimes.shared.data.remote.models.Article
import com.geniusforapp.nytimes.shared.data.remote.models.Result
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/
class MainViewModel @Inject constructor(
    private val compositeDisposable: CompositeDisposable,
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {

    private var articlesLiveData: MutableLiveData<Result>? = null
    private var query: String? = null

    private var filterValue = "1"

    fun getArticles(): LiveData<Result> {
        if (articlesLiveData != null) {
            return articlesLiveData as LiveData<Result>
        }
        return MutableLiveData<Result>().apply {
            getArticleFromApi(filterValue)
            articlesLiveData = this
        }
    }


    private fun MutableLiveData<Result>.getArticleFromApi(timeLong: String): MutableLiveData<Result> {
        postValue(Result.Loading)
        compositeDisposable.add(getArticlesUseCase.getArticles(timeLong).subscribe({
            postValue(
                Result.Success(it)
            )
        }, { postValue(Result.Error(it)) }))
        return this
    }

    fun getQuery(): String? = query

    fun refresh(number: String, forceRefresh: Boolean = false) {
        if (!forceRefresh) if (filterValue == number) return
        filterValue = number
        articlesLiveData?.postValue(Result.Success(arrayListOf<Article>()))
        articlesLiveData?.getArticleFromApi(number)
    }

    fun onRefresh() {
        refresh(filterValue, true)
    }
}


