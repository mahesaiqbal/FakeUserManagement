package com.mahesaiqbal.fakeusermanagement.network

import com.mahesaiqbal.fakeusermanagement.model.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {
    @GET("users")
    fun getListPlace(@Query("per_page") perPage: Int): Observable<User>
}