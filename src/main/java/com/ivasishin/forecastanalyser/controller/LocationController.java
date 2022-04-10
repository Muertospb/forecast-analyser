package com.ivasishin.forecastanalyser.controller;

import com.ivasishin.forecastanalyser.persistence.dto.CityDto;
import com.ivasishin.forecastanalyser.persistence.entities.User;
import com.ivasishin.forecastanalyser.persistence.repositories.CityRepo;
import com.ivasishin.forecastanalyser.persistence.repositories.UserRepo;
import com.ivasishin.forecastanalyser.service.LocationService;
import com.ivasishin.forecastanalyser.utils.ValueConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Controller
public class LocationController {
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private LocationService locationService;

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @PostMapping("/search")
    public String searchLocations(@AuthenticationPrincipal User user,
                                  @RequestParam(required = false) String request,
                                  Map<String, Object> model) {
        if (request != null) {
            try {
                List<CityDto> locations = locationService.findLocations(request);
                model.put("locations", locations);
            } catch (ResponseStatusException e) {
                model.put("message", "Something goes wrong. Request status is: " + e.getMessage());
            }
        }
        return "searchresult";
    }

    @PostMapping("/subscribe")
    public String subscribe(@AuthenticationPrincipal User user,
                            @RequestParam String name,
                            @RequestParam String lat,
                            @RequestParam String lon,
                            @RequestParam String country,
                            @RequestParam String state) {
        CityDto cityDto = new CityDto();
        cityDto.setName(name);
        cityDto.setLat(ValueConverter.getDoubleFromString(lat));
        cityDto.setLon(ValueConverter.getDoubleFromString(lon));
        cityDto.setCountry(country);
        cityDto.setState(state);

        locationService.subscribe(user, cityDto);
        return "redirect:/main";
    }
}
