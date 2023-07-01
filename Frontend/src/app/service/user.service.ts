import { Injectable } from '@angular/core';
import { ConfigService } from '../service/config.service';
import { ApiService } from '../api.service';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  currentUser :any;

  constructor(
    private apiService: ApiService,
    private config: ConfigService
  ) {
  }

  getOne() {


    return this.apiService.get(this.config._userone_url);

  }

  changeDisplayName(post:any) {

    // const body = `username=${user.username}&password=${user.password}`;
    const body = {

      'name': post.name,
      'desc': post.desc,

    };
    return this.apiService.post(this.config._userDispayNameSave_url, body)
      .subscribe((res) => {
        if(res.body == "NOT_ACCEPTABLE" || res.name == "HttpErrorResponse")
        {
          alert("Error")
        }else {
          alert("Save success");
          window.location.reload();
        }
      });
  }

}

