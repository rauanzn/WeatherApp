package com.example.domain.entity.converters;

import androidx.room.TypeConverter;

import com.example.domain.entity.Weather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DataConverter {
    @TypeConverter
    public String fromWeatherList(List<Weather> weatherList) {
        if (weatherList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Weather>>() {}.getType();
        String json = gson.toJson(weatherList, type);
        return json;
    }

    @TypeConverter
    public List<Weather> toWeatherList(String weatherString) {
        if (weatherString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Weather>>() {}.getType();
        List<Weather> weatherList = gson.fromJson(weatherString, type);
        return weatherList;
    }
}