package com.guapiston.bairesdev.data.remote

import androidx.lifecycle.MutableLiveData
import com.guapiston.bairesdev.data.DataSource
import com.guapiston.bairesdev.data.service.RetrofitService
import com.guapiston.bairesdev.model.Repository
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.github.com/"
class RemoteDataSource : DataSource{
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun retrieveProjects(callback: MutableLiveData<List<Repository>>) {
        val service = retrofit.create(RetrofitService::class.java)
        service.getGithubData().enqueue(object : Callback<List<Repository>>{
            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                println(t.message)
            }

            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            ) {
                callback.value = response.body()
            }

        })
    }

}