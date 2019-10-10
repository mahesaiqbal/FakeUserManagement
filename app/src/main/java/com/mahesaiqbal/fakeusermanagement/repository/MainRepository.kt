package com.mahesaiqbal.fakeusermanagement.repository

import com.mahesaiqbal.fakeusermanagement.model.User
import com.mahesaiqbal.fakeusermanagement.network.ApiObserver
import com.mahesaiqbal.fakeusermanagement.network.Client
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepository {

    private val apiService = Client.create()
    private val compositeDisposable = CompositeDisposable()

    fun requestListPlace(onResult: (User) -> Unit, onError: (Throwable) -> Unit){
        apiService.getListPlace(12)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: ApiObserver<User>(compositeDisposable){
                override fun onApiSuccess(data: User) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    fun onDestroy(){
        compositeDisposable.clear()
    }
}