package com.github.aminullah.covid.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.aminullah.covid.models.CasesCategoryModel
import com.github.aminullah.covid.utils.getCovidApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpecificCountryRepository(application: Application) {
    val progressState = MutableLiveData<Boolean>()
    val pakistanCases = MutableLiveData<CasesCategoryModel>()
    val countryCases = MutableLiveData<CasesCategoryModel>()

    fun pakistanCases() {
        val call: Call<List<CasesCategoryModel>>? = getCovidApi()?.getPakistanCovidData()
        call?.enqueue(object: Callback<List<CasesCategoryModel>> {
            override fun onFailure(call: Call<List<CasesCategoryModel>>, t: Throwable) {
                Log.e("ERROR", t.cause.toString())
            }

            override fun onResponse(
                call: Call<List<CasesCategoryModel>>,
                response: Response<List<CasesCategoryModel>>
            ) {
                pakistanCases.value = response.body()?.get(0)
            }
        })
    }
}
