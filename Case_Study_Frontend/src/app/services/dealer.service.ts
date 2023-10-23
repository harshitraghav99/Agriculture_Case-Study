import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Crop } from '../models/crop';

const headers = new HttpHeaders({
  "Content-Type": "application/json",
  'Authorization': `Basic ${localStorage.getItem('token')}` 
});

@Injectable({
  providedIn: 'root'
})
export class DealerService {


  constructor(private http:HttpClient) {
  
  }
  
  url="http://localhost:8090/dealer-service";
  getCrops(){
    console.log(this.http.get<Crop[]>(`${this.url}/fetchCrops`));
    
    return this.http.get<Crop[]>(`${this.url}/fetchCrops`,{headers});
  }
  addToCart(crop:Crop,cropId:any,quantity:number,dealerEmail:string){
    // const headers=new HttpHeaders({
    //   "Content-Type": "application/json"
    // });
    return this.http.post(`${this.url}/addToCart/${dealerEmail}/${quantity}`,crop,{headers})
  }
  getToken(){
    return localStorage.getItem('token')
  }
  getFarmerEmail(token:any){
    const payloadEmail=JSON.parse(atob(token.split('.')[1]));
    const email:string= payloadEmail.email;
    return email;
  }
}
