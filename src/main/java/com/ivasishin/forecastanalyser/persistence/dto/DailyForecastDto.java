package com.ivasishin.forecastanalyser.persistence.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class DailyForecastDto {
    private int dt;
    private TempDto temp;
    private int pressure;
    private int humidity;
    @JsonProperty("wind_speed")
    private double windSpeed;
    private ArrayList<WeatherDto> weather;
    private int clouds;
    private double uvi;
}