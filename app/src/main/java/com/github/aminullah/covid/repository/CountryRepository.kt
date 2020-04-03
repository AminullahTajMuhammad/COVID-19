package com.github.aminullah.covid.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.aminullah.covid.models.CountryModel
import com.github.aminullah.covid.utils.getCovidApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryRepository(application: Application) {

    val progress = MutableLiveData<Boolean>()
    val countryCases = MutableLiveData<CountryModel>()

    fun countryCases(countryName: String) {
        val call = getCovidApi()?.getSelectedCountryData(countryName)
        call?.enqueue(object : Callback<CountryModel> {
            override fun onFailure(call: Call<CountryModel>, t: Throwable) {
                Log.e("Country Data Error", t.message.toString())
            }

            override fun onResponse(call: Call<CountryModel>, response: Response<CountryModel>) {
                countryCases.value = response.body()
            }
        })
    }
}