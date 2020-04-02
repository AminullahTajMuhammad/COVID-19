package com.github.aminullah.covid.network

import com.github.aminullah.covid.models.PakistanCasesModel
import retrofit2.Call
import retrofit2.http.GET

interface CovidApi {
    @GET("countries/Pakistan/confirmed")
    fun getPakistanCovidData() : Call<List<PakistanCasesModel>>
}