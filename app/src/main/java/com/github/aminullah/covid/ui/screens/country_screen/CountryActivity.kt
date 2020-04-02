package com.github.aminullah.covid.ui.screens.country_screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.aminullah.covid.R
import com.github.aminullah.covid.adapters.CountryAdapter
import com.github.aminullah.covid.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.activity_country.*

class CountryActivity : AppCompatActivity() {

    private lateinit var viewModel: CountryViewModel
    private lateinit var mAdapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)

        viewModel.allCountries()
        viewModel.countries.observe(this, Observer {
            mAdapter.updateData(it.countries as ArrayList)
        })

        mAdapter = CountryAdapter(this)
        rv_country.apply {
            adapter = mAdapter
        }

    }
}
