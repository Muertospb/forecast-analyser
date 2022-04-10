package com.ivasishin.forecastanalyser.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "daily")
public class DailyForecast {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime date;
    @Column(name = "min_temp")
    private double minTemp;
    @Column(name = "max_temp")
    private double maxTemp;
    private int pressure;
    private int humidity;
    @Column(name = "wind_speed")
    private double windSpeed;
    @Column(name = "weather_code")
    private int weatherCode;
    private int clouds;
    private double uvi;
    @ManyToOne
    @JoinColumn(name="forecast_id", nullable=false)
    private Forecast forecast;
}
