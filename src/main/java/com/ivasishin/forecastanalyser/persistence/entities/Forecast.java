package com.ivasishin.forecastanalyser.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "forecast")
public class Forecast {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate date;
    private double temp;
    private int pressure;
    private int humidity;
    private double uvi;
    private int clouds;
    @Column(name = "wind_speed")
    private double windSpeed;
    @Column(name = "weather_code")
    private int weatherCode;
    @ManyToOne()
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
    @OneToMany(mappedBy = "forecast", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<DailyForecast> daily = new ArrayList<>();
}
