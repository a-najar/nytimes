package com.geniusforapp.nytimes.presentation.main.adapters

import android.widget.Filter
import com.geniusforapp.nytimes.shared.data.remote.models.Article
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @name nytimes
 * Copyrights (c) 2019-06-11 Created By Ahmad Najar
 **/
@Singleton
class FilterHelper @Inject constructor() : Filter() {

    private val originalList: ArrayList<Article> = arrayListOf()
    private val copyOriginalList: ArrayList<Article> = arrayListOf()

    var submitList: ((filter: List<Article>) -> Unit)? = null

    fun withList(data: List<Article>) {
        originalList.clear()
        originalList.addAll(data)
        copyOriginalList.clear()
        copyOriginalList.addAll(data)
    }

    override fun performFiltering(p0: CharSequence?): FilterResults {
        val result = FilterResults()
        if (p0.isNullOrEmpty()) {
            result.count = copyOriginalList.size
            result.values = copyOriginalList
        } else {
            originalList.clear()
            originalList.addAll(copyOriginalList)
            val filtered = originalList.filter { it.title.contains(p0.toString(), true) }
            result.count = filtered.size
            result.values = filtered
        }
        return result
    }

    override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
        submitList?.let { it(p1?.values as List<Article>) }
    }
}