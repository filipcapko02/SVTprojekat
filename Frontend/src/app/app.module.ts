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
import { AuthService } from './service/auth.service';
import {JWT_OPTIONS, JwtHelperService} from "@auth0/angular-jwt";
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from "@angular/common/http";
import { TokenInterceptor } from './tools/interceptor/TokenInterceptor';
import { UserService } from './service/user.service';
import { PostService } from './service/post.service';
import { GroupService } from './service/group.service';
import { CommentService } from './service/comment.service';
import { ConfigService } from './service/config.service';
import {FirebaseTSApp} from 'firebasets/firebasetsApp/firebaseTSApp';
import { environment } from './environments/environment';
import {MatButtonModule} from '@angular/material/button';
import { AuthenticatorComponent } from './tools/authenticator/authenticator.component'
import { MatBottomSheetModule } from '@angular/material/bottom-sheet';


const appRoute: Routes = [
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
    HomeComponent,
    AuthenticatorComponent
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
    FormsModule,
    HttpClientModule,
    MatButtonModule,
    MatBottomSheetModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  },AuthService, { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService,GroupService,PostService,ConfigService,UserService,CommentService],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(){
    FirebaseTSApp.init(environment.firebaseConfig);
  }
 }
