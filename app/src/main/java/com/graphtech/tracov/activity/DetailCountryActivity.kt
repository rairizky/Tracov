package com.graphtech.tracov.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.graphtech.tracov.R
import com.graphtech.tracov.model.summary.CountriesItem
import kotlinx.android.synthetic.main.activity_detail_country.*

class DetailCountryActivity : AppCompatActivity() {

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
        setDataCountry(countryItem)
    }

    private fun setDataCountry(item: CountriesItem) {
        val date = item.date
        val result = date?.substringBefore("T", "")
        countryDateHeader.text = result.toString()
        countryNameHeader.text = item.country
        countryConfirmed.setTarget(item.totalConfirmed!!.toLong())
        countryDeath.setTarget(item.totalDeaths!!.toLong())
        countryRecovered.setTarget(item.totalRecovered!!.toLong())
    }
}
