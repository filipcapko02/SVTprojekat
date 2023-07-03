import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import { UserService } from 'src/app/service/user.service';
import { GroupService } from 'src/app/service/group.service';
import { PostService } from 'src/app/service/post.service';
import { MatBottomSheet } from '@angular/material/bottom-sheet';
import { AuthenticatorComponent } from 'src/app/tools/authenticator/authenticator.component'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  

  
  constructor(private loginSheet:MatBottomSheet){ }

  ngOnInit(): void {
  }

  onLoginClick(){
    this.loginSheet.open(AuthenticatorComponent);
  }
}

