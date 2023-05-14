package com.example.janken

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class ResultViewModel : ViewModel() {
    private val _onClick = MutableSharedFlow<Boolean>()
    val onClick: SharedFlow<Boolean> = _onClick

    fun onButton() {
        viewModelScope.launch { _onClick.emit(true) }
    }

    fun setComHand(): Int {
        return (Math.random() * 3).toInt()
    }

    fun getJankenResult(myHand:Int, comHand:Int): Int {
        return (comHand - myHand + 3) % 3
    }
}