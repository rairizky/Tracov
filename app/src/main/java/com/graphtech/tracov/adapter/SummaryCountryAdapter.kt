package com.graphtech.tracov.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.graphtech.tracov.R
import com.graphtech.tracov.activity.DetailCountryActivity
import com.graphtech.tracov.model.summary.CountriesItem
import kotlinx.android.synthetic.main.item_summary_country.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SummaryCountryAdapter(private val context: Context?, var data: List<CountriesItem?>?) : RecyclerView.Adapter<SummaryCountryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_summary_country, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?:0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = data?.get(position)

        holder.tvNameCountry.text = country?.country
        holder.intentDetail.setOnClickListener {
            context?.startActivity<DetailCountryActivity>("countryItem" to country)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNameCountry = itemView.tvNameCountry
        var intentDetail = itemView.intentDetailFromSummary
    }
}