package com.ivasishin.forecastanalyser.persistence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto {
    private String name;
    private double lat;
    private double lon;
    private String country;
    private String state;
}
