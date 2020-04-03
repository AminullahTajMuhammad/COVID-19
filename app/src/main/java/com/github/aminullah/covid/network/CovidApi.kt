package com.github.aminullah.covid.network

import com.github.aminullah.covid.models.CountriesListModel
import com.github.aminullah.covid.models.CasesCategoryModel
import com.github.aminullah.covid.models.CountryModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CovidApi {
    @GET("countries/Pakistan/confirmed")
    fun getPakistanCovidData() : Call<List<CasesCategoryModel>>

    @GET("countries")
    fun getAllCountries(): Call<CountriesListModel>

    @GET("countries/{countryName}")
    fun getSelectedCountryData(@Path(value = "countryName", encoded = true ) countryName: String): Call<CountryModel>
}