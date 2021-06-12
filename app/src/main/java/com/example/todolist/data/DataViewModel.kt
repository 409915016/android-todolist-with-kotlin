package com.example.todolist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel: ViewModel() {
    private val _name = MutableLiveData("mather")

    val name: LiveData<String> = _name

    fun onConfirm(){
        _name.value =
    }

}