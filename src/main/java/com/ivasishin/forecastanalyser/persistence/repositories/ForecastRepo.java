package com.ivasishin.forecastanalyser.persistence.repositories;

import com.ivasishin.forecastanalyser.persistence.entities.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForecastRepo extends JpaRepository<Forecast, Long> {
}
