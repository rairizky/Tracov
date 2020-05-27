package com.graphtech.tracov.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.graphtech.tracov.R
import com.graphtech.tracov.adapter.SummaryCountryAdapter
import com.graphtech.tracov.model.summary.CountriesItem
import com.graphtech.tracov.model.summary.Global
import com.graphtech.tracov.presenter.SummaryPresenter
import com.graphtech.tracov.view.SummaryView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), SummaryView {

    private lateinit var summaryPresenter: SummaryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        summaryPresenter = SummaryPresenter(this)
        summaryPresenter.getSummaryData()
    }

    override fun onShowLoading() {
        shimmerSummaryCountry.visibility = View.VISIBLE
        shimmerSummaryCountry.startShimmer()
        rvSummaryCountry.visibility = View.GONE
    }

    override fun onHideLoading() {
        shimmerSummaryCountry.stopShimmer()
        shimmerSummaryCountry.visibility = View.GONE
        rvSummaryCountry.visibility = View.VISIBLE
    }

    override fun onSuccessGetGlobalData(globalResponse: Global?) {
        globalConfirmed.setTarget(globalResponse?.totalConfirmed!!.toLong())
        globalDeath.setTarget(globalResponse?.totalDeaths!!.toLong())
        globalRecovered.setTarget(globalResponse?.totalRecovered!!.toLong())
    }

    override fun onSuccessGetCountries(countriesItem: List<CountriesItem?>?) {
        rvSummaryCountry.layoutManager = LinearLayoutManager(this)
        rvSummaryCountry.adapter = SummaryCountryAdapter(this, countriesItem)
    }

    override fun onErrorGetSummary(msg: String) {
        toast(msg)
    }
}
