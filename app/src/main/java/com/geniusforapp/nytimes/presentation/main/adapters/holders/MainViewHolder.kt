package com.geniusforapp.nytimes.presentation.main.adapters.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geniusforapp.nytimes.shared.data.remote.models.Article
import com.geniusforapp.nytimes.shared.ktx.setTextOrInvisible
import kotlinx.android.synthetic.main.item_news.view.*

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/
class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindData(item: Article?) {
        item?.let {
            itemView.textTitle.setTextOrInvisible(it.title)
            itemView.textSubTitle.setTextOrInvisible(it.abstract)
            Glide.with(itemView.context).load(it.media[0].mediaMetadata[1].url).into(itemView.imageThumb)

        }
    }
}