import {Component, OnInit} from '@angular/core';
import { WeatherApiData } from "../models/weatherApiData";
import {WeatherApiService} from "../services/weather-api.service";
import {FavoritePlaceData} from "../models/favorite-place-data";
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  loadingLocalisation: boolean = true;
  favoritePlace: FavoritePlaceData = {surname: 'ma position'};


  constructor(
    private weatherApiService: WeatherApiService) {
  }

  ngOnInit(): void {
    this.getLocalisation();
  }

  getLocalisation() {
    navigator.geolocation.getCurrentPosition(position => {
      let lat = position.coords.latitude;
      let lon = position.coords.longitude;
      this.weatherApiService.getWeatherDataByPos(lat, lon, navigator.language).subscribe((datas) => {this.favoritePlace.weatherData = datas})
      //let testAsData: WeatherApiData = test;
      this.loadingLocalisation = false;
    });
  }
}
