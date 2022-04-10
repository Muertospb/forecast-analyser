package com.ivasishin.forecastanalyser.service;


import com.ivasishin.forecastanalyser.persistence.dto.CityDto;
import com.ivasishin.forecastanalyser.persistence.entities.City;
import com.ivasishin.forecastanalyser.persistence.entities.User;
import com.ivasishin.forecastanalyser.persistence.repositories.CityRepo;
import com.ivasishin.forecastanalyser.persistence.repositories.UserRepo;
import com.ivasishin.forecastanalyser.utils.DtoConverter;
import com.ivasishin.forecastanalyser.utils.ValueConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class LocationService {
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private UserRepo userRepo;
    @Value("${openweathermap.location.url.template}")
    private String locationUrlTemplate;
    @Value("${openweathermap.apikey}")
    private String apiKey;


    public List<CityDto> findLocations(String request) throws ResponseStatusException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CityDto[]> responseEntity = restTemplate.getForEntity(locationUrlTemplate.replace("{}", request) + apiKey, CityDto[].class);
        if (responseEntity.getStatusCodeValue() == 200) {
            return Arrays.asList(responseEntity.getBody());
        } else {
            throw new ResponseStatusException(responseEntity.getStatusCode());
        }
    }

    private boolean isSubscribed(Long userId, Double lat, Double lon) {
        Set<City> cities = cityRepo.findByUsersId(userId);
        return cities.stream().anyMatch(city -> city.getLon() == lon && city.getLat() == lat);
    }

    public void subscribe(User user, CityDto cityDto) {
        User dbUser = userRepo.findByUsername(user.getUsername());
        if (!isSubscribed(dbUser.getId(), cityDto.getLat(), cityDto.getLon())) {
            City city = cityRepo.findByLatAndLon(cityDto.getLat(), cityDto.getLon());
            if (city == null){
                city = DtoConverter.convertDtoToCity(cityDto);
            }

            city.getUsers().add(dbUser);
            cityRepo.save(city);

            dbUser.getCities().add(city);
            userRepo.save(dbUser);
        }
    }
}
