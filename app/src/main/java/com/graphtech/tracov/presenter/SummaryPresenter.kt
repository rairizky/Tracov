package com.graphtech.tracov.presenter

import com.graphtech.tracov.model.summary.SummaryResponse
import com.graphtech.tracov.network.NetworkConfig
import com.graphtech.tracov.view.SummaryView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SummaryPresenter(val summaryView: SummaryView) {

    fun getSummaryData() {
        summaryView.onShowLoading()
        NetworkConfig.service()
            .getSummary()
            .enqueue(object: Callback<SummaryResponse> {
                override fun onFailure(call: Call<SummaryResponse>, t: Throwable) {
                    summaryView.onHideLoading()
                    summaryView.onErrorGetSummary(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<SummaryResponse>,
                    response: Response<SummaryResponse>
                ) {
                    if (response.isSuccessful) {
                        summaryView.onHideLoading()
                        summaryView.onSuccessGetGlobalData(response.body()?.global)
                        summaryView.onSuccessGetCountries(response.body()?.countries)
                    }
                }

            })
    }
}