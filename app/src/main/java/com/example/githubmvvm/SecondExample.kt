package com.example.githubmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView

class SecondExample {
    var recyclerView: RecyclerView? = null
    var reponseBody: MutableLiveData<Any>? = MutableLiveData()

    private val _navigateToDetails = MutableLiveData<Boolean>()

    val navigateToDetails: LiveData<Boolean>
        get() = _navigateToDetails

    fun userClicksOnButton() {
        _navigateToDetails.value = true
    }
}
