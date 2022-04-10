package com.ivasishin.forecastanalyser.persistence.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class CurrentForecastDto {
    private int dt;
    private double temp;
    private int pressure;
    private int humidity;
    private double uvi;
    private int clouds;
    @JsonProperty("wind_speed")
    private double windSpeed;
    private ArrayList<WeatherDto> weather;
}