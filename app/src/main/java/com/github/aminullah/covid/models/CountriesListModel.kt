package com.github.aminullah.covid.models

import com.google.gson.annotations.SerializedName

data class CountriesListModel(
    @SerializedName("countries")
    var countries: List<CountryModel>
)