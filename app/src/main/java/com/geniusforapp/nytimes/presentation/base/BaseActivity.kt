package com.geniusforapp.nytimes.presentation.base

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/
abstract class BaseActivity : DaggerAppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        setToolbar()
        bindView(savedInstanceState)

    }

    private fun setToolbar() {
        toolbar?.let { setSupportActionBar(toolbar) }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (getMenuId() != 0) {
            menuInflater.inflate(getMenuId(), menu)
            menu?.let { onMenuCreated(it) }
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let { onMenuSelected(it, it.itemId) }
        return super.onOptionsItemSelected(item)
    }

    open fun onMenuSelected(item: MenuItem, id: Int) {}
    open fun onMenuCreated(menu: Menu) {}
    open fun getMenuId(): Int = 0

    abstract fun bindView(savedInstanceState: Bundle?)
    abstract fun getLayoutRes(): Int

}