import { Component, OnInit } from '@angular/core';
import { FirebaseTSAuth } from 'firebasets/firebasetsAuth/firebaseTSAuth';
import { MatBottomSheetRef } from '@angular/material/bottom-sheet';


@Component({
  selector: 'app-authenticator',
  templateUrl: './authenticator.component.html',
  styleUrls: ['./authenticator.component.css']
})
export class AuthenticatorComponent implements OnInit{
  state = AuthenticatorCompState.LOGIN
  firebasetsAuth: FirebaseTSAuth;
  constructor(private bottomSheetRef: MatBottomSheetRef){ 
    this.firebasetsAuth = new FirebaseTSAuth();
  }
  ngOnInit(): void {
  }

  onCreateAccountClick(){
    this.state = AuthenticatorCompState.REGISTER;
  }

  onLoginClick(){
    this.state = AuthenticatorCompState.LOGIN;
  }

  isLoginState(){
    return this.state == AuthenticatorCompState.LOGIN;
  }

  isRegisterState(){
    return this.state == AuthenticatorCompState.REGISTER;
  }
  getStateText(){
    switch(this.state){
      case AuthenticatorCompState.LOGIN:
        return "Login";
      case AuthenticatorCompState.REGISTER:
        return "Register";
      
    }
  }

  onLogin(
    loginEmail: HTMLInputElement,
    loginPassword: HTMLInputElement
  ){
    let email = loginEmail.value;
    let password = loginPassword.value;

    if(this.prazno(email) && this.prazno(password)) {
      this.firebasetsAuth.signInWith(
        {
          email: email,
          password: password,
          onComplete: (uc) => {
            this.bottomSheetRef.dismiss();
          },
          onFail: (err) => {
            alert(err);
          }
        }
      );
    }

  }

  onRegister(
    registerEmail: HTMLInputElement,
    registerPassword: HTMLInputElement,
    registerRPassword: HTMLInputElement
  ){
    let email = registerEmail.value;
    let password = registerPassword.value;
    let repeatPassword = registerRPassword.value;

    if(
      this.prazno(email) &&
      this.prazno(password) && 
      this.prazno(repeatPassword) &&
      this.jeIsto(password, repeatPassword)
    ){
      this.firebasetsAuth.createAccountWith(
        {
          email: email,
          password: password,
          onComplete: (uc) => {
            this.bottomSheetRef.dismiss();
          },
          onFail: (err) => {
            alert("Failed to create the account.");
          }
        }
      );
    }

  }

  prazno(text: string){
    return text != null && text.length > 0;
  }

  jeIsto(text: string, comparedWith: string){
    return text == comparedWith;
  }

}
export enum AuthenticatorCompState{
  LOGIN,REGISTER
}

