import { Component } from '@angular/core';
import { MatBottomSheet } from '@angular/material/bottom-sheet';
import { AuthenticatorComponent } from 'src/app/tools/authenticator/authenticator.component'
import { FirebaseTSAuth } from 'firebasets/firebasetsAuth/firebaseTSAuth';
import { Router } from '@angular/router';
import { FirebaseTSFirestore } from 'firebasets/firebasetsFirestore/firebaseTSFirestore';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'drustvena_mreza';
  auth = new FirebaseTSAuth();
  firestore = new FirebaseTSFirestore();
  userHasProfile = true;
  private static userDocument: UserDocument;

  constructor(private loginSheet: MatBottomSheet,
    private router: Router
  ){
  this.auth.listenToSignInStateChanges(
    user => {
      this.auth.checkSignInState(
        {
          whenSignedIn: user => {
              alert("Prijavili ste se")
          },
          whenSignedOut: user => {
            alert("Odjavili ste se")
          }
        }
      );
    }
  );
}
public static getUserDocument(){
  return AppComponent.userDocument;
}



onLogoutClick(){
  this.auth.signOut();
}

loggedIn(){
  return this.auth.isSignedIn();
}



  onLoginClick(){
    this.loginSheet.open(AuthenticatorComponent);
  }
}

export interface UserDocument {
  publicName: string;
  description: string;
  userId: string;
}