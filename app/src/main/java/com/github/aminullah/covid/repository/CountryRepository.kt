package com.github.aminullah.covid.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.aminullah.covid.models.CountriesListModel
import com.github.aminullah.covid.utils.getCovidApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryRepository(appication: Application) {
    var countries = MutableLiveData<CountriesListModel>()

    fun allCountries() {
        val call = getCovidApi()?.getAllCountries()
        call?.enqueue(object : Callback<CountriesListModel> {
            override fun onFailure(call: Call<CountriesListModel>, t: Throwable) {
                Log.e("ERROR", t.message.toString())
            }

            override fun onResponse(
                call: Call<CountriesListModel>,
                response: Response<CountriesListModel>
            ) {
               countries.value = response.body()
            }

        })
    }
}