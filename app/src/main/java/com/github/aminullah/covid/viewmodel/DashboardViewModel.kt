package com.github.aminullah.covid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.github.aminullah.covid.models.PakistanCasesModel
import com.github.aminullah.covid.repository.DashboardRepository

class DashboardViewModel(application: Application): AndroidViewModel(application) {
    private val repository = DashboardRepository(application)
    val progressState : LiveData<Boolean>
    val pakistanCases: LiveData<PakistanCasesModel>

    init {
        progressState = repository.progressState
        pakistanCases = repository.pakistanCases
    }

    fun pakistanCases() {
        repository.pakistanCases()
    }
}