import {Component, OnInit} from '@angular/core';
import { Location } from '@angular/common';
import {WeatherApiData} from "../models/weatherApiData";
import {FavoritePlaceData} from "../models/favorite-place-data";
import {WeatherApiService} from "../services/weather-api.service";
import {MeteoService} from "../services/meteo.service";
import {UserData} from "../models/user-data";
import {ActivatedRoute, Params, Router} from "@angular/router";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  user: UserData = {
    userId: 0,
    username: '',
    firstName: '',
    lastName: ''
  }
  favorites: FavoritePlaceData[] = [];

  constructor(private location:Location,private weatherApiService: WeatherApiService, private meteoService: MeteoService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => this.user.userId = params['userId']);
    this.getFavoritesData();
  }

  goBack(): void {
    this.router.navigate(['home']);
  }

  async getFavoritesData(){
    this.meteoService.getUser(this.user.userId).subscribe((datas) => {
      this.user.username = datas.username;
      this.user.firstName = datas.firstName;
      this.user.lastName = datas.lastName;
    });
    this.meteoService.getSelectionsByUser(this.user.userId).subscribe(async (datas) => {
      for (const data of datas) {
        let favoritePlace: FavoritePlaceData = {
          id: data.id,
          surname: data.locationSurname
        };
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

  async addPlace() {
    this.router.navigate([`/create-place`, this.user.userId]);
  }

  async deletePlace(place: FavoritePlaceData) {
    const index: number = this.favorites.indexOf(place);
    if (index !== -1) {
      this.favorites.splice(index, 1);
    }
    this.meteoService.deleteSelection(place.id!).subscribe((datas) => {
      console.log(datas)
    });
  }
}
