import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { ProfileComponent } from './tools/profile/profile.component';
import { PostComponent } from './pages/post/post.component';
import {MatDialogModule} from '@angular/material/dialog';
import {MatIconModule} from '@angular/material/icon';
import { CreatePostComponent } from './tools/create-post/create-post.component';
import { MatCardModule } from '@angular/material/card';
import { EditProfileComponent } from './tools/edit-profile/edit-profile.component';
import { ChangepasswordComponent } from './tools/changepassword/changepassword.component';
import { PostfeedComponent } from './pages/postfeed/postfeed.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './pages/home/home.component';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";

const appRoute: Routes = [
  { path: '', component: LoginComponent },
  { path: 'login', component: LoginComponent},
  { path: 'Home', component: HomeComponent },
  { path: 'register', component: RegisterComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    PostComponent,
    CreatePostComponent,
    EditProfileComponent,
    ChangepasswordComponent,
    PostfeedComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoute),
    BrowserAnimationsModule,
    MatDialogModule,
    MatIconModule,
    MatCardModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
