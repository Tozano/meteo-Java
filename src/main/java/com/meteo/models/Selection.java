package com.meteo.models;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Selection {
    private Long id;
    private String locationSurname;

    // if user wants a named city
    private String cityName;
    private String stateCode;
    private String countryCode;

    // if user wants a position or the city isn't recognized
    private double lon;
    private double lat;

    // options
    private boolean minMaxTemp = true;
    private boolean humidity = true;
    private boolean pressure = true;
    private boolean cloud = true;

    public Selection(Long id, String locationSurname){
        this.id = id;
        this.locationSurname = locationSurname;
    }

    // if we have a selection with a name
    public Selection(Long id, String locationSurname, String cityName, String stateCode, String countryCode){
        this.id = id;
        this.locationSurname = locationSurname;
        this.cityName = cityName;
        this.stateCode = stateCode;
        this.countryCode = countryCode;
    }

    // if we have a selection with positions
    public Selection(Long id, String locationSurname, double lon, double lat){
        this.id = id;
        this.locationSurname = locationSurname;
        this.lon = lon;
        this.lat = lat;
    }
}
