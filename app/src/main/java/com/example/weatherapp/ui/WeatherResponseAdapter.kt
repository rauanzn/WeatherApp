package com.example.weatherapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.WeatherResponse
import com.example.weatherapp.R
import com.example.weatherapp.listeners.OnWeatherClicked
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.weather_response_item.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class WeatherResponseAdapter(val onWeatherClicked: OnWeatherClicked) : RecyclerView.Adapter<WeatherResponseAdapter.WeatherResponseViewHolder>(){
    private val picasso = Picasso.get()
    private val formatter = SimpleDateFormat("dd/MM/yy, HH:mm")
    var list :ArrayList<WeatherResponse> = ArrayList()
        get(){
            return field
        } set(value){
            field = value
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherResponseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_response_item,parent, false)
        return WeatherResponseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: WeatherResponseViewHolder, position: Int) {
        holder.itemView.cityName.text = list[position].name
        holder.itemView.temperatureText.text = "${list[position].main.temp}K"
        holder.itemView.humidityText.text = list[position].main.humidity.toString()
        holder.itemView.date.text = formatter.format(list[position].date)
        picasso.load("https://openweathermap.org/img/wn/${list[position].weather.first().icon}@2x.png").into(holder.itemView.weatherIcon)
        holder.bind(list[position])
    }
    inner class WeatherResponseViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(model:WeatherResponse){
            itemView.setOnClickListener {
                onWeatherClicked.onWeatherClicked(model.pr_id)
            }
        }
    }
}