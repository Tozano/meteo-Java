import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { WeatherApiData } from "../models/weatherApiData";
import {UserData} from "../models/user-data";
import {FavoritePlaceData} from "../models/favorite-place-data";


@Injectable({
  providedIn: 'root'
})
export class MeteoService {
  backSide: string = "http://localhost:8080";
  constructor(private httpClient: HttpClient) { }

  postUser(userData:UserData): Observable<any> {
    let API_URL = this.backSide+"/api/users";
    return this.httpClient.post<any>(API_URL,userData);
  }

  getUser(idUser:number): Observable<any> {
    let API_URL = this.backSide+"/api/users/" + idUser;
    return this.httpClient.get<any>(API_URL);
  }

  login(username:string): Observable<any> {
    let API_URL = this.backSide+"/api/login/" + username;
    return this.httpClient.get<any>(API_URL);
  }

  postSelection(selection:{
    "locationSurname": string,
    "cityName": string,
    "stateCode": string | null,
    "countryCode": string | null,
    "user": {
      "id": number
    }
  }): Observable<any> {
    let API_URL = this.backSide+"/api/selections";
    return this.httpClient.post<any>(API_URL,selection);
  }

  getSelectionsByUser(idUser:number): Observable<any> {
    let API_URL = this.backSide+"/api/selections/getByIdUser/" + idUser;
    return this.httpClient.get<any>(API_URL);
  }

  deleteSelection(idSelection:number): Observable<any> {
    let API_URL = this.backSide+"/api/selections/" + idSelection;
    return this.httpClient.delete<any>(API_URL);
  }
}
