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
    fun bindData(
        item: Article?,
        onItemClick: ((view: View, position: Int, article: Article) -> Unit)?
    ) {
        item?.let {
            initText(it)
            loadImage(it)
            handleClick(onItemClick, it)
        }
    }

    private fun initText(it: Article) {
        itemView.textTitle.setTextOrInvisible(it.title)
        itemView.textSubTitle.setTextOrInvisible(it.abstract)
    }

    private fun loadImage(it: Article) {
        Glide.with(itemView.context).load(it.media[0].mediaMetadata[1].url)
            .into(itemView.imageThumb)
    }

    private fun handleClick(
        onItemClick: ((view: View, position: Int, article: Article) -> Unit)?,
        it: Article
    ) {
        itemView.setOnClickListener { view ->
            onItemClick?.let { it1 ->
                it1(
                    itemView,
                    adapterPosition,
                    it
                )
            }
        }
    }
}