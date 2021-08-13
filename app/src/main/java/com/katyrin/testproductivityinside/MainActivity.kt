package com.katyrin.testproductivityinside

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.katyrin.mylibrary.AbsMyLibraryActivity
import com.katyrin.testproductivityinside.databinding.ActivityMainBinding

class MainActivity : AbsMyLibraryActivity() {

    private var binding: ActivityMainBinding? = null
    private var uri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val imageUri: Uri? = savedInstanceState?.getParcelable(IMAGE_URI)
        imageUri?.let { setImageByUri(it) }
        initView()
    }

    private fun initView() {
        binding?.requestButton?.setOnClickListener { openNewScreen() }
        binding?.uploadButton?.setOnClickListener { callDialogSelectionImages() }
    }

    private fun openNewScreen() {
        createNewActivity(binding?.editText?.text.toString()) { textState ->
            Toast.makeText(this, textState, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(IMAGE_URI, uri)
    }

    override fun setImageByUri(uri: Uri) {
        this.uri = uri
        binding?.contentImageView?.let { imageView ->
            Glide.with(imageView)
                .load(uri)
                .into(imageView)
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private companion object {
        const val IMAGE_URI = "IMAGE_URI"
    }
}