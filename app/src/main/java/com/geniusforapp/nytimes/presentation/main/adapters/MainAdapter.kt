package com.geniusforapp.nytimes.presentation.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.geniusforapp.nytimes.R
import com.geniusforapp.nytimes.shared.data.remote.models.Article
import com.geniusforapp.nytimes.presentation.main.adapters.holders.MainViewHolder
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/

@Singleton
class MainAdapter @Inject constructor(diffCallback: DiffCallBack) : ListAdapter<Article, MainViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindData(getItem(holder.adapterPosition))
    }
}