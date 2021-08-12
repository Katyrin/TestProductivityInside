package com.katyrin.testproductivityinside

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.katyrin.testproductivityinside.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initView()
    }

    private fun initView() {
        binding?.requestButton?.setOnClickListener { }
        binding?.uploadButton?.setOnClickListener { }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}