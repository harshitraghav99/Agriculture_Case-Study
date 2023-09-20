import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url="http://localhost:8082/auth"
  constructor( private http:HttpClient) { }


  //calling server to generate token

  doLogin(credentials:any){
    //token generate
    return this.http.post(`${this.url}/authenticate`,credentials)

  }
  //for login user
  loginUser(token:string){
    localStorage.setItem('token',token)
    return true;
  }

  //check user is logged in or not
  isLoggedIn(){
    let token = localStorage.getItem('token');
    if(token== undefined && token==='null' && token == null ){
      return false;
    }
    else{
      return true;
    }
  }
  //for log out user
  logout(){
    localStorage.removeItem('token');
    return true;
  }
  getToken(){
    return localStorage.getItem('token');
  }
}
