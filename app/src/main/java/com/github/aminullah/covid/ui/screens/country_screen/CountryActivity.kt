package com.github.aminullah.covid.ui.screens.country_screen

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.aminullah.covid.R
import com.github.aminullah.covid.adapters.CountryAdapter
import com.github.aminullah.covid.listeneres.OnItemClickListener
import com.github.aminullah.covid.models.CountryNameModel
import com.github.aminullah.covid.ui.screens.country_data.CountryDataActivity
import com.github.aminullah.covid.utils.gone
import com.github.aminullah.covid.utils.launchActivityWithData
import com.github.aminullah.covid.utils.toolbarTitle
import com.github.aminullah.covid.utils.visible
import com.github.aminullah.covid.viewmodel.AllCountriesViewModel
import kotlinx.android.synthetic.main.activity_country.*

class CountryActivity : AppCompatActivity() {

    private lateinit var viewModel: AllCountriesViewModel
    private lateinit var mAdapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        toolbarTitle("All Countries")

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this).get(AllCountriesViewModel::class.java)

        viewModel.progress.observe(this, Observer { value ->
            if (value) {
                countries_progress.gone()
                rv_country.visible()
            } else {
                countries_progress.visible()
                rv_country.gone()
            }
        })

        viewModel.allCountries()
        viewModel.countries.observe(this, Observer {
            mAdapter.updateData(it.countries as ArrayList)
        })

        mAdapter = CountryAdapter(this, object : OnItemClickListener {
            override fun onItemClicked(position: Int) {
                val intent = Intent(this@CountryActivity, CountryDataActivity::class.java)
                intent.putExtra("country_name", mAdapter.list[position].name)
                launchActivityWithData(intent, isFinishedActivity = false)
            }
        })
        rv_country.apply {
            adapter = mAdapter
        }
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
