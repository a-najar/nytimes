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
class AdapterFilter @Inject constructor() : Filter() {

    private val originalList: ArrayList<Article> = arrayListOf()
    private val copyOriginalList: ArrayList<Article> = arrayListOf()

    var submitList: ((filter: List<Article>) -> Unit)? = null

    /**
     * add the list to the original and copy list to search inside
     */
    fun withList(data: List<Article>) {
        originalList.clear()
        originalList.addAll(data)
        copyOriginalList.clear()
        copyOriginalList.addAll(data)
    }

    override fun performFiltering(p0: CharSequence?): FilterResults {
        val result = FilterResults()
        if (p0.isNullOrEmpty()) {
            resetOriginalData(result)
        } else {
            searchInTheListsAndFilter(p0, result)
        }
        return result
    }

    /**
     * search inside the list and filter the data
     */
    private fun searchInTheListsAndFilter(
        p0: CharSequence,
        result: FilterResults
    ) {
        originalList.clear()
        originalList.addAll(copyOriginalList)
        val filtered = originalList.filter { it.title.contains(p0.toString(), true) }
        result.count = filtered.size
        result.values = filtered
    }

    private fun resetOriginalData(result: FilterResults) {
        result.count = copyOriginalList.size
        result.values = copyOriginalList
    }

    // post the data to the adapter function
    override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
        submitList?.let { it(p1?.values as List<Article>) }
    }
}