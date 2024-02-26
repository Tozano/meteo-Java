import {Component, OnInit} from '@angular/core';
import { Location } from '@angular/common';
import {WeatherApiData} from "../weatherApiData";
import {FavoritePlaceData} from "../favorite-place-data";
import {WeatherApiService} from "../weather-api.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  username: string = 'Tozano';
  firstName: string = 'Tanguy';
  lastName: string = 'ozano';
  favorites: FavoritePlaceData[] = [
    {
      surname: 'Maison',
      pos: {
        lat: 50.418391,
        lon: 3.177521
      }
    },
    {
      surname: 'Ecole',
      cityName: 'Arras'
    },
    {
      surname: 'Boulot',
      cityName: 'Lille'
    }
  ]

  constructor(private location:Location,private weatherApiService: WeatherApiService) {
  }

  ngOnInit(): void {
    this.getFavoritesData();
  }

  goBack(): void {
    this.location.back();
  }

  getFavoritesData(){
    for (const favorite of this.favorites) {
      if (favorite.cityName)
        this.weatherApiService.getWeatherDataByName(favorite.cityName, navigator.language).subscribe((datas) => {favorite.weatherData = datas});
      if (favorite.pos)
        this.weatherApiService.getWeatherDataByPos(favorite.pos.lat, favorite.pos.lon, navigator.language).subscribe((datas) => {favorite.weatherData = datas});
    }
  }
}
