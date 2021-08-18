package com.blogspot.devofandroid.covid19tracker.dataModel

import com.blogspot.devofandroid.covid19tracker.dataClass.GetData
import retrofit2.Call
import retrofit2.http.GET

interface ModelData {

    @GET("CovidCaseTrack.json")
    fun getPosts():Call<MutableList<GetData>>

}