package com.example.smartpharm.progressdialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object ProgressValue {
    private var _progress = MutableLiveData<Double>()

    val progress : LiveData<Double>
        get() = _progress

    fun updateProgress(prog : Double){
        _progress.value = prog
    }
}