import { Component,OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import { AuthService } from '../../service/auth.service';
import { FirebaseTSAuth } from 'firebasets/firebasetsAuth/firebaseTSAuth';

import {ActivatedRoute, Router} from "@angular/router";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  firebasetsAuth: FirebaseTSAuth;
  constructor(){ 
    this.firebasetsAuth = new FirebaseTSAuth();
  }
  
  ngOnInit(): void {
    
  }
  onLoginClick(
    loginEmail:HTMLInputElement,
    loginPassword:HTMLInputElement
  ){
    let email = loginEmail.value;
    let password = loginPassword.value;

    if(this.prazno(email)&&this.prazno(password)){
      this.firebasetsAuth.signInWith({
        email: email,
        password: email,
        onComplete: (uc) => {
          alert("Uspesno ste se prijavili")
        },
        onFail: (err) => {
          alert(err);
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

  onRegisterClick(){
    
  }
}
