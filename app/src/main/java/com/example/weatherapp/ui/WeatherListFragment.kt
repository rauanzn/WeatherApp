package com.example.weatherapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.domain.entity.WeatherResponse
import com.example.weatherapp.R
import com.example.weatherapp.listeners.OnWeatherClicked
import com.example.weatherapp.ui.base.MainViewModel
import kotlinx.android.synthetic.main.weather_list_fragment.view.*

class WeatherListFragment : Fragment(),OnWeatherClicked {

    val viewModel by lazy { MainViewModel.get<WeatherListViewModel>(this) }
    private var weatherAdapter = WeatherResponseAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.weather_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.adapterWeather.adapter = weatherAdapter
        view.list_toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.addWeather -> {
                    findNavController().navigate(R.id.action_weatherListFragment_to_searchFragment)
                    true
                }
            }
            false
        }
        viewModel.getFromDb().observe(viewLifecycleOwner, Observer {
            weatherAdapter.list.clear()
            weatherAdapter.list.addAll(it as List<WeatherResponse>)
            weatherAdapter.notifyDataSetChanged()
        })
    }

    override fun onWeatherClicked(id: Int) {
        findNavController().navigate(R.id.action_weatherListFragment_to_weatherDetailFragment, bundleOf("id" to id))
    }

}