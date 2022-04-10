package com.ivasishin.forecastanalyser.service;

import com.ivasishin.forecastanalyser.persistence.dto.CityDto;
import com.ivasishin.forecastanalyser.persistence.dto.ForecastDto;
import com.ivasishin.forecastanalyser.persistence.entities.City;
import com.ivasishin.forecastanalyser.persistence.entities.Forecast;
import com.ivasishin.forecastanalyser.persistence.repositories.CityRepo;
import com.ivasishin.forecastanalyser.persistence.repositories.ForecastRepo;
import com.ivasishin.forecastanalyser.utils.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OneCallService {
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private ForecastRepo forecastRepo;
    @Value("${openweathermap.forecast.url.template}")
    private String forecastUrlTemplate;
    @Value("${openweathermap.apikey}")
    private String apiKey;

    @Scheduled(cron = "0 30 * ? * *")
    private void getForecastData(){
        List<City> cityList = cityRepo.findAll();
        for (City city: cityList) {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<ForecastDto> responseEntity =
                    restTemplate.getForEntity(forecastUrlTemplate
                            .replace("{lat}", String.valueOf(city.getLat()))
                            .replace("{lon}", String.valueOf(city.getLon())) + apiKey, ForecastDto.class);
            if (responseEntity.getStatusCode().is2xxSuccessful()){
                Forecast forecast = DtoConverter.convertDtoToForecast(responseEntity.getBody());
                forecast.setCity(city);
                forecastRepo.save(forecast);
            }
        }
    }
}
