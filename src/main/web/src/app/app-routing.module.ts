import { NgModule } from '@angular/core';
import {Router, RouterModule, Routes} from '@angular/router';
import { ProfileComponent } from "./profile/profile.component";
import { HomeComponent } from "./home/home.component";
import { ConnectionComponent } from "./connection/connection.component";
import {CreateUserComponent} from "./create-user/create-user.component";
import {CreatePlaceComponent} from "./create-place/create-place.component";
import {UpdatePlaceComponent} from "./update-place/update-place.component";

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'connection', component: ConnectionComponent },
  { path: 'create-user', component: CreateUserComponent },
  { path: 'profile/:userId', component: ProfileComponent },
  { path: 'create-place/:userId', component: CreatePlaceComponent },
  { path: 'profile/:userId/update-place/:placeId', component: UpdatePlaceComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
