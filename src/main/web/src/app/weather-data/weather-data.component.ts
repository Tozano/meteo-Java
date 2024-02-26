import {Component, Input} from '@angular/core';
import { WeatherApiData } from "../weatherApiData";

@Component({
  selector: 'app-weather-data',
  templateUrl: './weather-data.component.html',
  styleUrls: ['./weather-data.component.scss']
})
export class WeatherDataComponent {
  @Input() weatherData?:WeatherApiData;
}
