import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from "@angular/material/button";
import { MatIconModule } from "@angular/material/icon";
import { MatExpansionModule } from "@angular/material/expansion";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfileComponent } from './profile/profile.component';
import { ConnectionComponent } from './connection/connection.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { WeatherDataComponent } from './weather-data/weather-data.component';
import {MatGridListModule} from "@angular/material/grid-list";
import {FormsModule} from "@angular/forms";
import { CreateUserComponent } from './create-user/create-user.component';
import { CreatePlaceComponent } from './create-place/create-place.component';
import { UpdatePlaceComponent } from './update-place/update-place.component';

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    ConnectionComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    WeatherDataComponent,
    CreateUserComponent,
    CreatePlaceComponent,
    UpdatePlaceComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        BrowserAnimationsModule,
        MatProgressSpinnerModule,
        MatButtonModule,
        MatIconModule,
        MatExpansionModule,
        MatGridListModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
