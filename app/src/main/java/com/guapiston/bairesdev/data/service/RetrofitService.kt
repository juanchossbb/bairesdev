package com.guapiston.bairesdev.data.service

import com.guapiston.bairesdev.model.Repository
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("users/juanchossbb/repos")
    fun getGithubData(@Query("per_page")limit : Int = 10, @Query("page") page : Int = 1) : Call<List<Repository>>
}