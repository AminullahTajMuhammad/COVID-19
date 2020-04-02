package com.github.aminullah.covid.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.github.aminullah.covid.models.PakistanCasesModel
import com.github.aminullah.covid.utils.getCovidApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardRepository(application: Application) {
    val progressState = MutableLiveData<Boolean>()
    val pakistanCases = MutableLiveData<PakistanCasesModel>()

    fun pakistanCases() {
        val call: Call<List<PakistanCasesModel>>? = getCovidApi()?.getPakistanCovidData()
        call?.enqueue(object: Callback<List<PakistanCasesModel>> {
            override fun onFailure(call: Call<List<PakistanCasesModel>>, t: Throwable) {
                Log.e("ERROR", t.cause.toString())
            }

            override fun onResponse(
                call: Call<List<PakistanCasesModel>>,
                response: Response<List<PakistanCasesModel>>
            ) {
                pakistanCases.value = response.body()?.get(0)
            }
        })
    }
}
