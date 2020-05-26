package com.graphtech.tracov.model.country


import com.google.gson.annotations.SerializedName

data class CountriesResponse(

	@field:SerializedName("Country")
	val country: String? = null,

	@field:SerializedName("Slug")
	val slug: String? = null,

	@field:SerializedName("ISO2")
	val iSO2: String? = null
)