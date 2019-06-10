package com.geniusforapp.nytimes.presentation.main.adapters

import androidx.recyclerview.widget.DiffUtil
import com.geniusforapp.nytimes.shared.data.remote.models.Article
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/

@Singleton
class DiffCallBack @Inject constructor() : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}