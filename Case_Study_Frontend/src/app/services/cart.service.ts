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
export class CartService {

  constructor(private http:HttpClient) { }
  url="http://localhost:8090/dealer-service";
  getCart(dealerEmail:string){
    return this.http.get<Crop[]>(`${this.url}/getCart/${dealerEmail}`,{headers})
  }
  removeCart(email:String){

  }
}
