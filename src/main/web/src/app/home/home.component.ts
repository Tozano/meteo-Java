import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  city: string='Arras'
  temperature: number=10.5
  weather: string='Nuageux'
}
