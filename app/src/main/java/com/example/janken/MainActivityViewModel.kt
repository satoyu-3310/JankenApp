package com.example.janken

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val _myHand = MutableLiveData<Int>()
    val myHand: LiveData<Int> = _myHand

    fun setResult(num: Int) {
        _myHand.value = num
    }
}