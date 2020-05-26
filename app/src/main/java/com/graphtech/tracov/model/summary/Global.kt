package com.graphtech.tracov.model.summary

import com.google.gson.annotations.SerializedName

data class Global(

	@field:SerializedName("NewRecovered")
	val newRecovered: Int? = null,

	@field:SerializedName("NewDeaths")
	val newDeaths: Int? = null,

	@field:SerializedName("TotalRecovered")
	val totalRecovered: Int? = null,

	@field:SerializedName("TotalConfirmed")
	val totalConfirmed: Int? = null,

	@field:SerializedName("NewConfirmed")
	val newConfirmed: Int? = null,

	@field:SerializedName("TotalDeaths")
	val totalDeaths: Int? = null
)