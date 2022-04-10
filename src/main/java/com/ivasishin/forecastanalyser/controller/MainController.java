package com.ivasishin.forecastanalyser.controller;

import com.ivasishin.forecastanalyser.persistence.entities.City;
import com.ivasishin.forecastanalyser.persistence.entities.User;
import com.ivasishin.forecastanalyser.persistence.repositories.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private CityRepo cityRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user, Map<String, Object> model) {
        Iterable<City> cities = cityRepo.findByUsersId(user.getId());

        model.put("cities", cities);
        return "main";
    }
}
