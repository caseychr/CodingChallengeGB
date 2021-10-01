package com.gb.codingchalleng

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GuideViewModel(): ViewModel() {

    val repository = GuideRepository(NetworkService.service())

    val guideLiveData = MutableLiveData<Resource<Guides>>()

    fun getGuides() {
        CoroutineScope(Dispatchers.Default).launch {
            guideLiveData.postValue(repository.getGuides())
        }
    }
}