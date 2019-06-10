package com.geniusforapp.nytimes.presentation.main.menu

import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import com.geniusforapp.nytimes.R

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/
class SearchMenuBuilder constructor(menu: Menu) {

    private lateinit var searchView: SearchView
    private var menuItem: MenuItem = menu.findItem(R.id.searchView)

    fun getSearchView(query: String?): SearchView {
        searchView = menuItem.actionView as SearchView
        handleQuery(query)
        return searchView
    }

    private fun handleQuery(query: String?) {
        query?.let {
            menuItem.expandActionView()
            searchView.setQuery(query, true)
        }
    }
}