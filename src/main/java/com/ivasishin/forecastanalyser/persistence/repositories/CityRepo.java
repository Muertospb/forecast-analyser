package com.ivasishin.forecastanalyser.persistence.repositories;

import com.ivasishin.forecastanalyser.persistence.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {
    Set<City> findByUsersId(Long userId);
    City findByLatAndLon(Double lat, Double lon);
}
