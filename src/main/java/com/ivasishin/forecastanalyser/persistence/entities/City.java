package com.ivasishin.forecastanalyser.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private double lat;
    private double lon;
    private String country;
    private String state;
    @ManyToMany(mappedBy = "cities")
    private Set<User> users = new HashSet<>();
    @OneToMany(mappedBy = "city")
    private List<Forecast> forecast;
}
