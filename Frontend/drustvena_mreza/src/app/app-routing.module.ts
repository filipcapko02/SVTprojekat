import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CommonModule} from '@angular/common';
import {HomeComponent} from './components/home/home.component';
import {LoginComponent} from './components/login/login.component';
import { appGuard } from './guards/app.guard';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    canActivate: [appGuard]
  },
  {
    path: 'login',
    component: LoginComponent
  }
];


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
