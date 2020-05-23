package com.github.aminullah.covid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.github.aminullah.covid.models.CountryModel
import com.github.aminullah.covid.repository.CountryRepository
import com.github.aminullah.covid.repository.SpecificCountryRepository

class CountryViewModel(application: Application): AndroidViewModel(application) {

    private val repository = CountryRepository(application)
    private val progressState : LiveData<Boolean>
    val countryCases : LiveData<CountryModel>

    init {
        progressState = repository.progress
        countryCases = repository.countryCases
    }

    fun countryCases(countryName: String) {
        repository.countryCases(countryName)
    }
}