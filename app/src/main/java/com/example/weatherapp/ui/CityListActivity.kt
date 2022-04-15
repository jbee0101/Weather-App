package com.example.weatherapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.common.GenericAdapter
import com.example.weatherapp.databinding.CityListActivityBinding
import com.example.weatherapp.network.City

class CityListActivity : AppBaseActivity() {

    val TAG = "CityListActivity"

    private val binding: CityListActivityBinding by ActivityBindingProperty(R.layout.city_list_activity)

    private lateinit var viewModel: CitiesViewModel
    private lateinit var mAdapter: GenericAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(CitiesViewModel::class.java)

        viewModel.onGetCurrentWeather()
        binding.appBar.lblTitle.text = "Weather"

        mAdapter = GenericAdapter(viewModel.citiesList, this, R.layout.city_cell)
        { view: View, city: String ->
            Log.e(TAG, "GenericAdapter onClickItem:  $city")

            val intent = Intent(this@CityListActivity, WeatherDetailActivity::class.java)
            intent.putExtra("city", city)
            startActivity(intent)
        }

        val layoutManager = LinearLayoutManager(this)
        binding.rvHeadlines.layoutManager = layoutManager
        binding.rvHeadlines.adapter = mAdapter

        viewModel.newsResponse.observe(this) { response ->

            Log.e(TAG, "newsResponse: $response")
            binding.item = response
        }

    }
}