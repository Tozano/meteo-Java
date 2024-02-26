import { Component } from '@angular/core';
import { Location } from '@angular/common';
import {WeatherApiData} from "../weatherApi";
import {FavoritePlaceData} from "../favorite-place-data";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent {
  firstName: string = 'Tanguy';
  lastName: string = 'ozano';
  favorites: FavoritePlaceData[] = [
    {
      surname: 'Maison',
      weatherData: {
        city:'Arras',
        temperature: 11,
        weather:
          [
            {
              description: 'couvert'
            }
          ]
      }
    },
    {
      surname: 'Boulot',
      weatherData: {
        city:'Lille',
        temperature: 10.4,
        weather:
          [
            {
              description: 'couvert'
            }
          ]
      }
    }
  ]

  constructor(private location:Location) {
  }
  goBack(): void {
    this.location.back();
  }
}
