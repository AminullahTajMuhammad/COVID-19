package com.github.aminullah.covid.ui.screens.country_data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.aminullah.covid.R
import com.github.aminullah.covid.utils.toolbarTitle
import com.github.aminullah.covid.viewmodel.AllCountriesViewModel
import com.github.aminullah.covid.viewmodel.CountryViewModel
import com.github.aminullah.covid.viewmodel.SpecificCountryViewModel
import kotlinx.android.synthetic.main.activity_country_data.*
import kotlinx.android.synthetic.main.item_view_countries.*

class CountryDataActivity : AppCompatActivity() {

    lateinit var viewModel: CountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_data)

        toolbarTitle(getExtra()!!)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)

        viewModel.countryCases(getExtra()!!)
        viewModel.countryCases.observe(this, Observer {
            tv_country_total_number.text = it.confirmed_cat.value.toString()
            tv_country_recover_number.text = it.recovered_cat.value.toString()
            tv_country_deaths_number.text = it.deaths_cat.value.toString()
        })


    }

    private fun getExtra(): String? {
        var countryName: String? = "null"
        if(intent.hasExtra("country_name")) {
            countryName = intent.getStringExtra("country_name")
        }
        return countryName
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
