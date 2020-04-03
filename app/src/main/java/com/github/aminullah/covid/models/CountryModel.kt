package com.github.aminullah.covid.models

import com.google.gson.annotations.SerializedName

data class CountryModel(
    @SerializedName("confirmed")
    var confirmed_cat: CaseCategory,

    @SerializedName("recovered")
    var recovered_cat: CaseCategory,

    @SerializedName("deaths")
    var deaths_cat: CaseCategory
)

data class CaseCategory(
    @SerializedName("value")
    var value: Int
)