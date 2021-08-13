package com.katyrin.testproductivityinside

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.katyrin.mylibrary.MyLibrary
import com.katyrin.mylibrary.MyLibraryImpl
import com.katyrin.testproductivityinside.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var myLibrary: MyLibrary? = null
    private var uri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val imageUri: Uri? = savedInstanceState?.getParcelable("IMAGE_URI")
        imageUri?.let { setImage(it) }
        initMyLibrary()
        initView()
    }

    private fun initMyLibrary() {
        myLibrary = MyLibraryImpl(this) { uri -> setImage(uri) }
    }

    private fun setImage(uri: Uri) {
        this.uri = uri
        binding?.contentImageView?.let { imageView ->
            Glide.with(imageView)
                .load(uri)
                .into(imageView)
        }
    }

    private fun initView() {
        binding?.requestButton?.setOnClickListener { openNewScreen() }
        binding?.uploadButton?.setOnClickListener {
            myLibrary?.callDialogSelectionImages()
        }
    }

    private fun openNewScreen() {
        myLibrary?.createNewActivity(binding?.editText?.text.toString()) { textState ->
            Toast.makeText(this, textState, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("IMAGE_URI", uri)
    }

    override fun onDestroy() {
        binding = null
        myLibrary = null
        super.onDestroy()
    }
}