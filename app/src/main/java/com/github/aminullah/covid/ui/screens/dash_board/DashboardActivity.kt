package com.github.aminullah.covid.ui.screens.dash_board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.aminullah.covid.R
import com.github.aminullah.covid.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.activity_dashboard_activity.*

class DashboardActivity : AppCompatActivity() {

    private lateinit var viewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_activity)

        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        viewModel.pakistanCases()
        viewModel.pakistanCases.observe(this, Observer {
            tv_total_number.text = it.confirmed
            tv_active_number.text = it.active
            tv_deaths_number.text = it.deaths
            tv_recover_number.text = it.recovered
        })
    }
}
