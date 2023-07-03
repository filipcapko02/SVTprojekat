import { Component,OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import { AuthService } from '../../service/auth.service';
import { FirebaseTSAuth } from 'firebasets/firebasetsAuth/firebaseTSAuth';


import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  
  firebasetsAuth: FirebaseTSAuth;
  constructor(){ 
    this.firebasetsAuth = new FirebaseTSAuth();
  }
  ngOnInit(): void {

  }
  OnRegisterClick(registerRPassword:HTMLInputElement,
    registerEmail:HTMLInputElement,
    registerPassword:HTMLInputElement)
    {
    let rpassword = registerRPassword.value;
    let email = registerEmail.value;
    let password = registerPassword.value;
    if(this.prazno(email) && this.prazno(password) && this.prazno(rpassword) && this.sePoklapa(password,rpassword)){ 
    this.firebasetsAuth.createAccountWith({
      email: email,
      password: password,
      onComplete: (uc) => {
        alert("Akaunt je uspešno kreiran");
        registerEmail.value = "";
        registerPassword.value = "";
        registerRPassword.value = "";
      },
      onFail: (err) => {
        alert("Akaunt nije uspeo da se kreira");
      }
    });
  }
  }

  prazno(text: string){
    return text != null && text.length > 0;
  }

  sePoklapa(text: string,comparedWith: string){
    return text == comparedWith;
  }

  OnLoginClick(){}
}


