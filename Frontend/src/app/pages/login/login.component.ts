import { Component,OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import { AuthService } from '../../service/auth.service';

import {ActivatedRoute, Router} from "@angular/router";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  title = 'Login';

  forma = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });

  submitted = false;

  private returnUrl: any;
  public a: any;

  constructor(
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder
  ) {
  }

  ngOnInit() {

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';

  }


back()
{
  let returnUrl : String;
  returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  this.router.navigate([returnUrl]);
}


  submitForm(){ 
  this.submitted = true;
    console.warn('Your order has been submitted', this.forma.value);
    this.authService.login(this.forma.value)
  }
}
