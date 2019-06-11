package com.geniusforapp.nytimes.shared.ktx

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.geniusforapp.nytimes.R

/**
 * @name nytimes
 * Copyrights (c) 2019-06-11 Created By Ahmad Najar
 **/
fun FragmentActivity.loadWebPage(url: String) {
    val customTabsIntent = CustomTabsIntent.Builder()
    customTabsIntent.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
    customTabsIntent.build().launchUrl(this, Uri.parse(url))
}