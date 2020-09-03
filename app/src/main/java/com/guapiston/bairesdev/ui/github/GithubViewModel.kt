package com.guapiston.bairesdev.ui.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guapiston.bairesdev.data.remote.RemoteDataSource
import com.guapiston.bairesdev.model.Repository
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubViewModel : ViewModel() {
    val datasource by lazy { RemoteDataSource() }
    val result = MutableLiveData<List<Repository>>()

    init {
        datasource.retrieveProjects(result)
    }
}