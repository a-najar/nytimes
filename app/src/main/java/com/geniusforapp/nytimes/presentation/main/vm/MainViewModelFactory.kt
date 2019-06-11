package com.geniusforapp.nytimes.presentation.main.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geniusforapp.nytimes.presentation.main.domain.usecases.GetArticlesUseCase
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/
@Suppress("UNCHECKED_CAST")
class MainViewModelFactory @Inject constructor(
    private val compositeDisposable: CompositeDisposable,
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(compositeDisposable, getArticlesUseCase) as T
    }
}