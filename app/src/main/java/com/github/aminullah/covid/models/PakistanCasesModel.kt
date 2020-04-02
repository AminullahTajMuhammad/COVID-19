package com.github.aminullah.covid.models

import com.google.gson.annotations.SerializedName
import java.lang.StringBuilder

data class PakistanCasesModel(
    @SerializedName("confirmed")
    var confirmed: String,

    @SerializedName("recovered")
    var recovered: String,

    @SerializedName("deaths")
    var deaths: String,

    @SerializedName("active")
    var active: String
)