package com.github.aminullah.covid.models

import com.google.gson.annotations.SerializedName

data class CountryNameModel (
    @SerializedName("name")
    var name: String
)