package com.github.aminullah.covid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.github.aminullah.covid.models.CountriesListModel
import com.github.aminullah.covid.repository.AllCountriesRepository

class AllCountriesViewModel(application: Application): AndroidViewModel(application) {
    var countries: LiveData<CountriesListModel>
    var progress: LiveData<Boolean>

    private var repo = AllCountriesRepository(application)

    init {
        this.countries = repo.countries
        this.progress = repo.progress
    }

    fun currentProgressState() {
        repo.changeProgressState()
    }

    fun allCountries() {
        repo.allCountries()
    }
}