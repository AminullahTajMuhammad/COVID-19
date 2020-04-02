package com.github.aminullah.covid.models

import com.google.gson.annotations.SerializedName

data class CountryModel (
    @SerializedName("name")
    var name: String
)