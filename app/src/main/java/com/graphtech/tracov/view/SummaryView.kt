package com.graphtech.tracov.view

import android.provider.Settings
import com.graphtech.tracov.model.summary.CountriesItem
import com.graphtech.tracov.model.summary.Global

interface SummaryView {
    fun onShowLoading()
    fun onHideLoading()
    fun onSuccessGetGlobalData(globalResponse: Global?)
    fun onSuccessGetCountries(countriesItem: List<CountriesItem?>?)
    fun onErrorGetSummary(msg: String)
}