import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { WeatherApiData } from "../models/weatherApiData";


@Injectable({
  providedIn: 'root'
})
export class WeatherApiService {
  API_KEY:string = "e770987537502ea5e63dd4234268b7a2";

  constructor(private httpClient: HttpClient) { }

  getWeatherDataByName(cityName:string, langage:string): Observable<WeatherApiData> {
    let API_URL = "http://api.openweathermap.org/data/2.5/weather?q="+cityName+"&lang=" + langage + "&units=metric&APPID=" + this.API_KEY;
    return this.httpClient.get<WeatherApiData>(API_URL)
  }

  getWeatherDataByPos(lat:number, lon:number, langage:string): Observable<WeatherApiData> {
    let API_URL = "http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&lang=" + langage + "&units=metric&APPID=" + this.API_KEY;
    return this.httpClient.get<WeatherApiData>(API_URL)
  }
}
