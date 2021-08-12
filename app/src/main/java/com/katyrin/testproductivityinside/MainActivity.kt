package com.katyrin.testproductivityinside

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.katyrin.mylibrary.MyLibrary
import com.katyrin.mylibrary.MyLibraryImpl
import com.katyrin.testproductivityinside.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var myLibrary: MyLibrary? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        myLibrary = MyLibraryImpl(this)
        initView()
    }

    private fun initView() {
        binding?.requestButton?.setOnClickListener { openNewScreen() }
        binding?.uploadButton?.setOnClickListener { }
    }

    private fun openNewScreen() {
        myLibrary?.createNewActivity(binding?.editText?.text.toString()) { textState ->
            Toast.makeText(this, textState, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        binding = null
        myLibrary = null
        super.onDestroy()
    }
}