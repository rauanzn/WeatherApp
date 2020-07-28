package com.example.weatherapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.Status
import com.example.weatherapp.ui.base.MainViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.weather_detail_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*

class WeatherDetailFragment : Fragment() {

    companion object {
        fun newInstance() = WeatherDetailFragment()
    }

    private val viewModel by lazy { MainViewModel.get<WeatherDetailViewModel>(this) }
    private val weatherId by lazy { arguments?.getInt("id",-1)?:-1 }
    private val picasso = Picasso.get()
    private val monthFormatter = SimpleDateFormat("MMM")
    private val dayFormatter = SimpleDateFormat("dd")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.weather_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner, Observer {
            when(it.status){
                Status.LOADING -> { view.progressBar.visibility = View.VISIBLE }
                Status.SUCCESS -> { view.progressBar.visibility = View.GONE }
                Status.ERROR -> {  }
            }
        })
        viewModel.getWeatherById(weatherId).observe(viewLifecycleOwner, Observer {
            view.cityLocation.text = it.name
            view.main.text = it.weather.first().main
            view.temperatureValue.text = "${it.main.temp}K"
            view.windValue.text = "${it.wind.speed} m/s"
            view.humidityValue.text = "${it.main.humidity}%"
            view.month.text = monthFormatter.format(it.date)
            view.day.text = dayFormatter.format(it.date)
            view.pressure.text = "Pressure: ${it.main.pressure} Pa"
            picasso.load("https://openweathermap.org/img/wn/${it.weather.first().icon}@2x.png").into(view.iconWeather)
        })
        view.detail_toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

    }

}