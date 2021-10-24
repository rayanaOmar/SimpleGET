package com.example.simplegetrequest

import retrofit2.Call
import retrofit2.http.GET


interface APIInterface {
    @GET("/api/activity")
    fun doGetListResources(): Call<ActivityDetails?>?
}

class ActivityDetails( var activity: String,var type: String, var key: String)
