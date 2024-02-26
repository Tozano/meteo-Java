import {Component, OnInit} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { WeatherApiData } from "../weatherApi";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  loadingLocalisation: boolean = true;
  weatherData: WeatherApiData = {
    city: 'Arras',
    temperature: 10.5,
    weather: [{description:'couvert'}]
  };

  API_KEY:string = "e770987537502ea5e63dd4234268b7a2";
  langage: string = "fr";
  lat: number = 0;
  lon: number = 0;

  constructor(
    private http: HttpClient,) {
  }

  ngOnInit(): void {
    this.getLocalisation();
  }

  getLocalisation() {
    navigator.geolocation.getCurrentPosition(position => {
      this.lat = position.coords.latitude;
      this.lon = position.coords.longitude;
      this.getData();
      this.loadingLocalisation = false;
    });
  }
  /** GET heroes from the server */
  getData() {
    let API_URL = "http://api.openweathermap.org/data/2.5/weather?lat=" + this.lat + "&lon=" + this.lon + "&lang=" + this.langage + "&APPID=" + this.API_KEY;
    console.log(API_URL);
    let test =  this.http.get(API_URL);
    // @ts-ignore
    //let test2 = JSON.parse(test);
    //console.log(test2)
  }
}
