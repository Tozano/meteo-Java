package com.meteo.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="selection")
public class Selection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_selection")
    private Long id;
    @Column(name = "location_surname")
    private String locationSurname;

    // if user wants a named city
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "state_code")
    private String stateCode;
    @Column(name = "country_code")
    private String countryCode;

    // if user wants a position or the city isn't recognized
    @Column(name = "lon")
    private double lon;
    @Column(name = "lat")
    private double lat;

    // options
    @Column(name = "min_max_temp")
    private boolean minMaxTemp = true;
    @Column(name = "humidity")
    private boolean humidity = true;
    @Column(name = "pressure")
    private boolean pressure = true;
    @Column(name = "cloud")
    private boolean cloud = true;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

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

/*
CREATE TABLE selection (
    id_selection int PRIMARY KEY NOT NULL,
    location_surname VARCHAR(255),
    city_name VARCHAR(255),
    state_code VARCHAR(20),
    country_code VARCHAR(20),
    lon float,
    lan float,
    min_max_temp bool,
    humidity bool,
    pressure bool,
    cloud bool,
    id_user int NOT NULL
);

 */
