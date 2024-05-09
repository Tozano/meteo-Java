import {Component, Input} from '@angular/core';
import {FavoritePlaceData} from "../models/favorite-place-data";

@Component({
  selector: 'app-weather-data',
  templateUrl: './weather-data.component.html',
  styleUrls: ['./weather-data.component.scss']
})
export class WeatherDataComponent {
  @Input() favoritePlace?:FavoritePlaceData;
}
