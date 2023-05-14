package com.example.janken

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _guButton = MutableLiveData<Boolean>()
    private val _chokiButton = MutableLiveData<Boolean>()
    private val _paButton = MutableLiveData<Boolean>()
    val guButton: LiveData<Boolean> = _guButton
    val chokiButton: LiveData<Boolean> = _chokiButton
    val paButton: LiveData<Boolean> = _paButton

    fun onClickGuButton() {
        _guButton.value = true
    }
    fun offClickGuButton() {
        _guButton.value = false
    }

    fun onClickChokiButton() {
        _chokiButton.value = true
    }
    fun offClickChokiButton() {
        _chokiButton.value = false
    }

    fun onClickPaButton() {
        _paButton.value = true
    }
    fun offClickPaButton() {
        _paButton.value = false
    }
}