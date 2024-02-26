import {Component, OnInit} from '@angular/core';
import { WeatherApiData } from "../weatherApiData";
import {WeatherApiService} from "../weather-api.service";
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  loadingLocalisation: boolean = true;
  weatherData: WeatherApiData | undefined;


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
      this.weatherApiService.getWeatherDataByPos(lat, lon, navigator.language).subscribe((datas) => {this.weatherData = datas})
      //let testAsData: WeatherApiData = test;
      this.loadingLocalisation = false;
    });
  }
}
