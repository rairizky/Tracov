package com.graphtech.tracov.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.graphtech.tracov.R
import com.graphtech.tracov.model.dayone.DayOneResponse
import kotlinx.android.synthetic.main.item_dayone_country_stat.view.*

class DayOneCountryAdapter (private val context: Context?, var data: List<DayOneResponse?>?)
    : RecyclerView.Adapter<DayOneCountryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dayone_country_stat, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?:0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stat = data?.get(position)

        val date = stat?.date
        val result = date?.substringBefore("T", "")

        holder.tvDate.text = result
        holder.tvConfirmed.text = stat?.confirmed.toString()
        holder.tvDeath.text = stat?.deaths.toString()
        holder.tvRecovered.text = stat?.recovered.toString()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvConfirmed = itemView.dayOneConfirmed
        var tvDeath = itemView.dayOneDeath
        var tvRecovered = itemView.dayOneRecovered
        var tvDate = itemView.dayOneDate
    }
}