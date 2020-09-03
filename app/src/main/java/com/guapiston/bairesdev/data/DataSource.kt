package com.guapiston.bairesdev.data

import androidx.lifecycle.MutableLiveData
import com.guapiston.bairesdev.model.Repository
import io.reactivex.Observable
import retrofit2.Call
import javax.security.auth.callback.Callback

interface DataSource {
    fun retrieveProjects(callback: MutableLiveData<List<Repository>>)
}