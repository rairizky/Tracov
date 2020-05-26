package com.graphtech.tracov.network

import com.graphtech.tracov.model.country.CountriesResponse
import com.graphtech.tracov.model.summary.SummaryResponse
import retrofit2.Call
import retrofit2.http.GET

interface Covid19ApiService {
    @GET("summary")
    fun getSummary() : Call<SummaryResponse>

    @GET("countries")
    fun getCountries() : Call<List<CountriesResponse>>
}