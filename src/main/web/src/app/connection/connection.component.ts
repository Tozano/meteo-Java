import { Component } from '@angular/core';
import {UserData} from "../models/user-data";
import {MeteoService} from "../services/meteo.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-connection',
  templateUrl: './connection.component.html',
  styleUrls: ['./connection.component.scss']
})
export class ConnectionComponent {
  user: UserData = {
    username: '',
    firstName: '',
    lastName: ''
  }
  isWrongUsername: boolean = false;

  constructor(private meteoService: MeteoService, private router: Router) {
  }
  onSubmit() {
    if (this.user.username) {
      this.meteoService.login(this.user.username).subscribe((datas) => {
        if(datas > 0) {
          this.isWrongUsername = false;
          this.router.navigate([`/profile`, datas]);
        } else {
          this.isWrongUsername = true;
        }
      });
    }
  }
}
