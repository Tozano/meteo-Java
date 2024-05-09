import {Component, OnInit} from '@angular/core';
import { Location } from '@angular/common';
import {WeatherApiData} from "../models/weatherApiData";
import {FavoritePlaceData} from "../models/favorite-place-data";
import {WeatherApiService} from "../services/weather-api.service";
import {MeteoService} from "../services/meteo.service";
import {UserData} from "../models/user-data";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  user: UserData = {
    username: '',
    firstName: '',
    lastName: ''
  }
  favorites: FavoritePlaceData[] = [];

  constructor(private location:Location,private weatherApiService: WeatherApiService, private meteoService: MeteoService) {
  }

  ngOnInit(): void {
    this.getFavoritesData();
  }

  goBack(): void {
    this.location.back();
  }

  async getFavoritesData(){
    this.meteoService.getUser(2).subscribe((datas) => {
      this.user.username = datas.username;
      this.user.firstName = datas.firstName;
      this.user.lastName = datas.lastName;
    });
    this.meteoService.getSelectionsByUser(2).subscribe(async (datas) => {
      for (const data of datas) {
        let favoritePlace: FavoritePlaceData = {surname: data.locationSurname};
        if (data.cityName) {
          favoritePlace.cityName = data.cityName;
          await this.weatherApiService.getWeatherDataByName(data.cityName, navigator.language).subscribe((openWeatherDatas) => {
            favoritePlace.weatherData = openWeatherDatas
          });
        } else if (data.lon && data.lat) {
          favoritePlace.pos = {lon: data.lon, lat: data.lat};
          await this.weatherApiService.getWeatherDataByPos(data.lat, data.lon, navigator.language).subscribe((openWeatherDatas) => {
            favoritePlace.weatherData = openWeatherDatas
          });
        }
        this.favorites.push(favoritePlace);
      }
    })
  }
}
