package com.katyrin.mylibrary

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MyLibraryImpl(
    private val activity: AppCompatActivity,
    private val onGetUri: (Uri) -> Unit
) : MyLibrary {

    private val disposable: CompositeDisposable = CompositeDisposable()
    private val activityLauncher = with(activity) {
        registerForActivityResult(MainActivityContract()) { intent ->
            if (intent != null) takePersistableUriPermission(intent)
        }
    }

    override fun createNewActivity(requestText: String, stateListener: (String) -> Unit): Unit =
        with(activity) {
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

    override fun callDialogSelectionImages() {
        activityLauncher.launch(null)
    }

    private fun takePersistableUriPermission(data: Intent): Unit =
        with(activity) {
            val uri = data.data ?: return
            val takeFlags = data.flags.and(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                .or(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)

            try {
                contentResolver.takePersistableUriPermission(uri, takeFlags)
                onGetUri(uri)
            } catch (exception: SecurityException) {
                Toast.makeText(activity, exception.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
}