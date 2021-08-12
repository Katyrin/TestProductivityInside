package com.katyrin.mylibrary

import android.content.Context

class MyLibraryImpl(private val context: Context) : MyLibrary {

    override fun createNewActivity(requestText: String, stateListener: (String) -> Unit): Unit =
        with(context) {
            startActivity(
                LibraryActivity.getIntent(this, requestText)
            )
        }
}