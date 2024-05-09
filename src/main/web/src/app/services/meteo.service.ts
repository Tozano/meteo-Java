import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { WeatherApiData } from "../models/weatherApiData";


@Injectable({
  providedIn: 'root'
})
export class MeteoService {
  constructor(private httpClient: HttpClient) { }

  getUser(idUser:number): Observable<any> {
    let API_URL = "http://localhost:8080/api/users/" + idUser;
    return this.httpClient.get<any>(API_URL);
  }

  getSelectionsByUser(idUser:number): Observable<any> {
    let API_URL = "http://localhost:8080/api/selections/getByIdUser/" + idUser;
    return this.httpClient.get<any>(API_URL);
  }
}
