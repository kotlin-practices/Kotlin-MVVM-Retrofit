package com.example.mvvmretro.examples

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExampleVM : ViewModel() {
    val examples = MutableLiveData<String>()
    fun addExample(example: String) {
        examples.postValue(example)
    }

    fun getExamples(): LiveData<String> {
        return examples
    }
}