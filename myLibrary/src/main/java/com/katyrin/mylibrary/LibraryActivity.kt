package com.katyrin.mylibrary

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.katyrin.mylibrary.databinding.ActivityLibraryBinding

internal class LibraryActivity : AppCompatActivity() {

    private var binding: ActivityLibraryBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        savedInstanceState ?: RxBus.publish(getString(R.string.on_open))
        super.onCreate(savedInstanceState)
        binding = ActivityLibraryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initViews()
    }

    private fun initViews() {
        val bundle = intent.extras
        binding?.textView?.text = bundle?.getString(REQUEST_TEXT_EXTRA)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        RxBus.publish(getString(R.string.on_closed))
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    companion object {
        private const val REQUEST_TEXT_EXTRA = "REQUEST_TEXT_EXTRA"

        fun getIntent(context: Context, word: String): Intent =
            Intent(context, LibraryActivity::class.java).apply {
                putExtra(REQUEST_TEXT_EXTRA, word)
            }
    }
}