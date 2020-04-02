package com.github.aminullah.covid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.github.aminullah.covid.models.CountriesListModel
import com.github.aminullah.covid.repository.CountryRepository

class CountryViewModel(application: Application): AndroidViewModel(application) {
    var countries: LiveData<CountriesListModel>
    private var repo = CountryRepository(application)

    init {
        countries = repo.countries
    }

    fun allCountries() {
        repo.allCountries()
    }
}