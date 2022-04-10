package com.ivasishin.forecastanalyser.utils;

import com.ivasishin.forecastanalyser.persistence.dto.CityDto;
import com.ivasishin.forecastanalyser.persistence.dto.DailyForecastDto;
import com.ivasishin.forecastanalyser.persistence.dto.ForecastDto;
import com.ivasishin.forecastanalyser.persistence.entities.City;
import com.ivasishin.forecastanalyser.persistence.entities.DailyForecast;
import com.ivasishin.forecastanalyser.persistence.entities.Forecast;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

public class DtoConverter {
    public static City convertDtoToCity(CityDto cityDto) {
        City city = new City();
        city.setName(cityDto.getName());
        city.setLat(cityDto.getLat());
        city.setLon(cityDto.getLon());
        city.setCountry(cityDto.getCountry());
        city.setState(cityDto.getState());
        return city;
    }

    public static Forecast convertDtoToForecast(ForecastDto forecastDto) {
        Forecast forecast = new Forecast();
        forecast.setDate(LocalDateTime.ofEpochSecond
                (forecastDto.getCurrent().getDt(), 0, ZoneOffset.ofTotalSeconds(forecastDto.getTimezoneOffset()))
                .toLocalDate());
        forecast.setTemp(forecastDto.getCurrent().getTemp());
        forecast.setClouds(forecastDto.getCurrent().getClouds());
        forecast.setHumidity(forecastDto.getCurrent().getHumidity());
        forecast.setPressure(forecastDto.getCurrent().getPressure());
        forecast.setUvi(forecastDto.getCurrent().getUvi());
        forecast.setWeatherCode(forecastDto.getCurrent().getWeather().get(0).getId());
        forecast.setWindSpeed(forecastDto.getCurrent().getWindSpeed());
        forecast.setDaily(new ArrayList<>());
        for (DailyForecastDto dto : forecastDto.getDaily()) {
            DailyForecast dailyForecast = convertDtoToDailyForecast(dto, forecastDto.getTimezoneOffset());
            dailyForecast.setForecast(forecast);
            forecast.getDaily().add(dailyForecast);
        }
        return forecast;
    }

    private static DailyForecast convertDtoToDailyForecast(DailyForecastDto dto, int timeZoneOffser) {
        DailyForecast dailyForecast = new DailyForecast();
        dailyForecast.setDate(LocalDateTime.ofEpochSecond
                (dto.getDt(), 0, ZoneOffset.ofTotalSeconds(timeZoneOffser))
                .toLocalDate());
        dailyForecast.setClouds(dto.getClouds());
        dailyForecast.setHumidity(dto.getHumidity());
        dailyForecast.setPressure(dto.getPressure());
        dailyForecast.setUvi(dto.getUvi());
        dailyForecast.setWeatherCode(dto.getWeather().get(0).getId());
        dailyForecast.setWindSpeed(dto.getWindSpeed());
        dailyForecast.setMinTemp(dto.getTemp().getMin());
        dailyForecast.setMaxTemp(dto.getTemp().getMax());
        return dailyForecast;
    }
}
