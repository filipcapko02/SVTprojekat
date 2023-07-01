import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {
  login_url: string;
  _api_url: string;
  _user_url: string;
   _users_url: string;
   _signup_url: string;
  _passchange_url: string;
  _groupcreate_url: string;
  _postcreate_url: string;
  _postcreateGroup_url: string;
  _postAll_url: string;
  _postAllAll_url: string;
  _deletepost_url: string;
  _postone_url: string;
  _postsave_url: string;
  _groupone_url: string;
  _groupall_url: string;
  _groupsave_url: string;
  _groupdelete_url: string;
  _userDispayNameSave_url :string;
  _userone_url :string;
  _addReaction_url:string;
  constructor() {
    this._api_url = 'http://localhost:8080/api';
    this._user_url = this._api_url + '/users';
    this.login_url =this._user_url + '/login';
    this._passchange_url = this._user_url + "/changepassword";
  this._groupcreate_url = this._api_url + "/group/create"
    this._userone_url = this._user_url +"/getUser";
    this._users_url = this._user_url + '/all';
  this._postcreate_url = this._api_url + "/post/create";
    this._postcreateGroup_url = this._api_url + "/post/GroupPost";
  this._userDispayNameSave_url = this._user_url +"/SaveDName";
this._addReaction_url = this._api_url + "/comment/addLike";
    this._signup_url = this._user_url + '/signup';
this._postAll_url = this._api_url + "/post/All";
    this._postAllAll_url = this._api_url + "/post/AllAll";
    this._deletepost_url= this._api_url + "/post/delete";
    this._postone_url = this._api_url + "/post/one";
    this._postsave_url = this._api_url + "/post/save";
    this._groupone_url= this._api_url + "/group/one";
    this._groupall_url= this._api_url + "/group/getAll";
    this. _groupsave_url= this._api_url + "/group/save";
    this.  _groupdelete_url =this._api_url + "/group/delete";
  }
}
