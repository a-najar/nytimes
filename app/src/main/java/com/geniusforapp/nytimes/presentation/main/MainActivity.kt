package com.geniusforapp.nytimes.presentation.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.geniusforapp.nytimes.R
import com.geniusforapp.nytimes.presentation.base.BaseActivity
import com.geniusforapp.nytimes.presentation.main.adapters.MainAdapter
import com.geniusforapp.nytimes.presentation.main.menu.SearchMenuBuilder
import com.geniusforapp.nytimes.presentation.main.vm.MainViewModel
import com.geniusforapp.nytimes.presentation.main.vm.MainViewModelFactory
import com.geniusforapp.nytimes.shared.data.remote.models.Article
import com.geniusforapp.nytimes.shared.data.remote.models.Result
import com.geniusforapp.nytimes.shared.data.remote.models.Result.Loading
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(), SearchView.OnQueryTextListener,
    SwipeRefreshLayout.OnRefreshListener {


    @Inject
    lateinit var mainAdapter: MainAdapter

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    lateinit var viewModel: MainViewModel

    // bind view and write the ui code here this method will fire in onCreate
    override fun bindView(savedInstanceState: Bundle?) {
        initSwipeRefresh()
        initItemsList()
        initVm()
    }

    private fun initSwipeRefresh() {
        swipeRefresh.setOnRefreshListener(this)
    }

    // init viewModel and ad the factory to it to inject the needed class
    private fun initVm() {
        viewModel = ViewModelProviders.of(this, mainViewModelFactory)[MainViewModel::class.java]
        viewModel.getArticles().observe(this, Observer { handleResult(it) })
    }


    @Suppress("UNCHECKED_CAST")
    // handle the view model observer result
    private fun handleResult(result: Result) {
        when (result) {
            is Loading -> showLoading()
            is Result.Success<*> -> showArticles(result.data as List<Article>)
            is Result.Error -> handleError(result)
        }
    }

    // show articles add add the data to the adapter
    private fun showArticles(articles: List<Article>) {
        swipeRefresh.isRefreshing = false
        listItems.visibility = View.VISIBLE
        mainAdapter.submitList(articles)
    }

    // handle error to with dialog
    private fun handleError(result: Result.Error) {
        swipeRefresh.isRefreshing = false
        AlertDialog.Builder(this).setTitle(R.string.dialog_title_error)
            .setMessage(result.error.message)
            .setCancelable(false)
            .setNeutralButton(android.R.string.ok) { dialogInterface, i -> dialogInterface.dismiss() }
            .show()
    }

    // handle loading progress bar
    private fun showLoading() {
        swipeRefresh.isRefreshing = true
        listItems.visibility = View.GONE
    }

    // init list of the news items and add the adapter to it
    private fun initItemsList() {
        with(listItems) {
            itemAnimator = DefaultItemAnimator()
            adapter = mainAdapter
            layoutManager = linearLayoutManager
        }
    }

    //set content view layout the xml to get the data from it
    override fun getLayoutRes(): Int = R.layout.activity_main

    // provide menu id so i can use it
    override fun getMenuId(): Int = R.menu.menu_main

    override fun onMenuCreated(menu: Menu) {
        super.onMenuCreated(menu)
        with(SearchMenuBuilder(menu).getSearchView(viewModel.getQuery())) {
            setOnQueryTextListener(
                this@MainActivity
            )
        }
    }

    override fun onMenuSelected(item: MenuItem, id: Int) {
        super.onMenuSelected(item, id)
        when (id) {
            R.id.actionOne -> viewModel.refresh("1")
            R.id.actionSeven -> viewModel.refresh("7")
            R.id.actionMonth -> viewModel.refresh("30")
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        viewModel.search(newText)
        return true
    }

    override fun onRefresh() {
        viewModel.onRefresh()
    }

}
