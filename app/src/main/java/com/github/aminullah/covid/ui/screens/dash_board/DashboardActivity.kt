package com.github.aminullah.covid.ui.screens.dash_board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.aminullah.covid.R
import com.github.aminullah.covid.ui.screens.country_screen.CountryActivity
import com.github.aminullah.covid.utils.launchActivity
import com.github.aminullah.covid.utils.toolbarTitle
import com.github.aminullah.covid.viewmodel.SpecificCountryViewModel
import kotlinx.android.synthetic.main.activity_dashboard_activity.*

class DashboardActivity : AppCompatActivity() {

    private lateinit var viewModel: SpecificCountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_activity)

        toolbarTitle("Dashboard")

        viewModel = ViewModelProvider(this).get(SpecificCountryViewModel::class.java)

        viewModel.pakistanCases()
        viewModel.pakistanCases.observe(this, Observer {
            tv_total_number.text = it.confirmed
            tv_active_number.text = it.active
            tv_deaths_number.text = it.deaths
            tv_recover_number.text = it.recovered
        })

        fab_country.setOnClickListener {
            this.launchActivity<CountryActivity>(this, false)
        }
    }
}
