package com.graphtech.tracov.network


import com.graphtech.tracov.model.dayone.DayOneResponse
import com.graphtech.tracov.model.summary.SummaryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Covid19ApiService {
    @GET("summary")
    fun getSummary() : Call<SummaryResponse>

    @GET("dayone/country/{getCountry}")
    fun getDayOne(
        @Path("getCountry") getCountry : String
    ) : Call<List<DayOneResponse>>
}