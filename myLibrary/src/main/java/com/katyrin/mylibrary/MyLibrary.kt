package com.katyrin.mylibrary

interface MyLibrary {
    fun createNewActivity(requestText: String, stateListener: (String) -> Unit)
}