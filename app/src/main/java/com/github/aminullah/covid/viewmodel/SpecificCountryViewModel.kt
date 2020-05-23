package com.github.aminullah.covid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.github.aminullah.covid.models.CasesCategoryModel
import com.github.aminullah.covid.repository.SpecificCountryRepository

class SpecificCountryViewModel(application: Application): AndroidViewModel(application) {
    private val repository = SpecificCountryRepository(application)
    private val progressState : LiveData<Boolean>
    val pakistanCases: LiveData<CasesCategoryModel>

    init {
        progressState = repository.progressState
        pakistanCases = repository.pakistanCases
    }

    fun pakistanCases() {
        repository.pakistanCases()
    }
}