package com.geniusforapp.nytimes.shared.ktx

import android.text.TextUtils
import android.view.View
import android.widget.TextView

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/

fun TextView.setTextOrInvisible(newText: String?) {
    if (TextUtils.isEmpty(newText)) {
        visibility = View.INVISIBLE
    } else {
        visibility = View.VISIBLE
        text = newText
    }
}

fun TextView.setTextOrGone(newText: String?) {
    if (TextUtils.isEmpty(newText)) {
        visibility = View.GONE
    } else {
        visibility = View.VISIBLE
        text = newText
    }
}