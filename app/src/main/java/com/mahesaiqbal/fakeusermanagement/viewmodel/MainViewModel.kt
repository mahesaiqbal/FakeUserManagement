package com.mahesaiqbal.fakeusermanagement.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mahesaiqbal.fakeusermanagement.model.User
import com.mahesaiqbal.fakeusermanagement.repository.MainRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MainRepository()

    var users: MutableLiveData<User> = MutableLiveData()
    var error: MutableLiveData<Throwable> = MutableLiveData()

    fun getUsers() {
        repository.requestListPlace({
            users.postValue(it)
        }, {
            error.postValue(it)
        })
    }

    override fun onCleared() {
        super.onCleared()
        repository.onDestroy()
    }

}