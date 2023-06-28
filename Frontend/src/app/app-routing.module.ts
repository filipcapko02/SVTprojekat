import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './pages/register/register.component';
import { LoginComponent } from './pages/login/login.component';
import { PostComponent } from './pages/post/post.component';
import { ProfileComponent } from './tools/profile/profile.component';
import { EditProfileComponent } from './tools/edit-profile/edit-profile.component';
import { ChangepasswordComponent } from './tools/changepassword/changepassword.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'post', component: PostComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'editprofile', component: EditProfileComponent },
  { path: 'changepassword', component: ChangepasswordComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
