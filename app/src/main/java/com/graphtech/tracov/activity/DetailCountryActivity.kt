package com.graphtech.tracov.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.graphtech.tracov.R
import com.graphtech.tracov.adapter.DayOneCountryAdapter
import com.graphtech.tracov.model.dayone.DayOneResponse
import com.graphtech.tracov.model.summary.CountriesItem
import com.graphtech.tracov.presenter.DayOnePresenter
import com.graphtech.tracov.view.DayOneView
import kotlinx.android.synthetic.main.activity_detail_country.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class DetailCountryActivity : AppCompatActivity(), DayOneView {

    private lateinit var dayOnePrenter: DayOnePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_country)

        // back to main
        intentBackFromDetailSummary.setOnClickListener {
            finish()
        }

        // get intent parcelize
        val countryItem = intent.getParcelableExtra("countryItem") as CountriesItem

        // data country header
        val date = countryItem.date
        val result = date?.substringBefore("T", "")
        countryDateHeader.text = result.toString()
        countryNameHeader.text = countryItem.country
        countryConfirmed.setTarget(countryItem.totalConfirmed!!.toLong())
        countryDeath.setTarget(countryItem.totalDeaths!!.toLong())
        countryRecovered.setTarget(countryItem.totalRecovered!!.toLong())

        // setup stats graphic
        dayOnePrenter = DayOnePresenter(this)
        setupGraphic(countryItem.country.toString())

    }

    private fun setupGraphic(country: String) {
        val parseCountry = country.toLowerCase()
        dayOnePrenter.getDataCountry(parseCountry)
    }

    override fun onShowLoading() {
        shimmerDayOneStats.visibility = View.VISIBLE
        shimmerDayOneStats.startShimmer()
        rvDayOneStat.visibility = View.GONE
    }

    override fun onHideLoading() {
        shimmerDayOneStats.stopShimmer()
        shimmerDayOneStats.visibility = View.GONE
        rvDayOneStat.visibility = View.VISIBLE
    }

    override fun onSuccessGetDayOne(data: List<DayOneResponse?>?) {
        rvDayOneStat.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvDayOneStat.adapter = DayOneCountryAdapter(this, data)
    }

    override fun onErrorGetDayOne(msg: String) {
        toast(msg)
    }
}
