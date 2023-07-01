import { Component } from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import { UserService } from 'src/app/service/user.service';
import { GroupService } from 'src/app/service/group.service';
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  forma = new FormGroup({
    sGroup: new FormControl(),
    post: new FormControl(''),
  });

  submitted = false;

  /**
   * Notification message from received
   * form request or router
   */







   posta:any;
  postaa:any;
  groups:any;



  submitForm() {
    /**
     * Innocent until proven guilty
     */

    this.submitted = true;
    console.warn('Your order has been submitted', this.forma.value);
    this.postService.create(this.forma.value)
    location.reload();



  }
  constructor(
    private authService: AuthService,
    private userService: UserService,
    private router: Router,
    private route: ActivatedRoute,
    private groupService: GroupService,
    private formBuilder: FormBuilder,
    private postService : PostService,

  ) {
    if(this.authService.isAuthenticated())
    {

    }
    else {
      let returnUrl : String;
      returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
      this.router.navigate([returnUrl]);
    }

  }



  myFunction()
  {
    let returnUrl : String;
    returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/passchange';
    this.router.navigate([returnUrl]);
  }
  LogOut()
  {
    let returnUrl : String;
    localStorage.clear();
    returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    this.router.navigate([returnUrl]);
  }
  ngOnInit() {

    this.postService.getAll().subscribe((data) => {
  this.posta = data;

    });

    this.postService.getAllAll().subscribe((data) => {
      this.postaa = data;

    });this.groupService.getAll().subscribe((data) => {
      this.groups = data;

    });

  }
}

