package com.katyrin.mylibrary

import android.content.Context
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MyLibraryImpl(private val context: Context) : MyLibrary {

    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun createNewActivity(requestText: String, stateListener: (String) -> Unit): Unit =
        with(context) {
            subscribeState(stateListener)
            startActivity(
                LibraryActivity.getIntent(this, requestText)
            )
        }

    private fun subscribeState(stateListener: (String) -> Unit) {
        disposable.clear()
        disposable.add(
            RxBus.subscribe { stateListener(it) }
        )
    }
}