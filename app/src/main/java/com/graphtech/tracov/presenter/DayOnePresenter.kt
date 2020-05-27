package com.graphtech.tracov.presenter

import com.graphtech.tracov.model.dayone.DayOneResponse
import com.graphtech.tracov.network.NetworkConfig
import com.graphtech.tracov.view.DayOneView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DayOnePresenter(val dayOneView: DayOneView) {

    fun getDataCountry(getCountry: String?) {

        dayOneView.onHideLoading()
        NetworkConfig.service()
            .getDayOne(getCountry.toString())
            .enqueue(object : Callback<List<DayOneResponse>>{
                override fun onFailure(call: Call<List<DayOneResponse>>, t: Throwable) {
                    dayOneView.onHideLoading()
                    dayOneView.onErrorGetDayOne(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<List<DayOneResponse>>,
                    response: Response<List<DayOneResponse>>
                ) {
                    if (response.isSuccessful) {
                        dayOneView.onHideLoading()
                        dayOneView.onSuccessGetDayOne(response.body())
                    }
                }

            })
    }
}