import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignUpService {

  url="http://localhost:8082/auth";

  constructor(private http:HttpClient) { }
  
  doSignUp(credentials:any){
    //token generate
    const headers = new HttpHeaders({
      "Content-Type": "application/json",
      'Authorization': "Basic" + btoa(credentials)
});

    return this.http.post(`${this.url}/registerFarmer`,credentials,{headers,responseType:'text'})

  }
}
