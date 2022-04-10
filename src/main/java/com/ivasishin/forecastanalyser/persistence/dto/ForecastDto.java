package com.ivasishin.forecastanalyser.persistence.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ForecastDto {
    private CurrentForecastDto current;
    private ArrayList<DailyForecastDto> daily;
    @JsonProperty("timezone_offset")
    private int timezoneOffset;
}
