package com.graphtech.tracov.model.summary


import com.google.gson.annotations.SerializedName

data class SummaryResponse(

	@field:SerializedName("Countries")
	val countries: List<CountriesItem?>? = null,

	@field:SerializedName("Global")
	val global: Global? = null,

	@field:SerializedName("Date")
	val date: String? = null
)