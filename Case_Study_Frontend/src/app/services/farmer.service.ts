import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Crop } from '../models/crop';
import { Farmer } from '../models/farmer';

@Injectable({
  providedIn: 'root'
})
export class FarmerService {

  
  constructor(private http:HttpClient) { }
  url="http://localhost:8090/farmer-service";

  addCrops(crop:Crop){
    const headers = new HttpHeaders({
      "Content-Type": "application/json",
      'Authorization': `Basic ${localStorage.getItem('token')}`
  });
  return this.http.post(`${this.url}/addcrops/${crop.farmerEmail}`,crop,{headers,responseType:'text'})
  }

  
  
  getCrops(email:string){
    const headers = new HttpHeaders({
      "Content-Type": "application/json",
      'Authorization': `Basic ${localStorage.getItem('token')}` 
  });
    return this.http.get<Crop[]>(`${this.url}/fetchCropsFarmerEmail/${email}`,{headers});
  }
  getFarmerName(){
    // return this.http.get
  }
  getFarmerEmail(token:any){
    const payloadEmail=JSON.parse(atob(token.split('.')[1]));
    const email:string= payloadEmail.email;
    return email;
  }
  getToken(){
    return localStorage.getItem('token')
  }
  // getFarmer(email:string){
  //   return this.http.get<Farmer>(`${this.url}/fetchCropsFarmerEmail/${email}`);
  // }


  updateCropsIncrease(cropName:string,quantity:number,email:string){

    const headers = new HttpHeaders({
      "Content-Type": "application/json",
      'Authorization': `Basic ${localStorage.getItem('token')}` 
  });
    return this.http.put(`${this.url}/updateCropInc/${email}/${cropName}/${quantity}`,null,{headers});

  }
  updateCropsDecrease(cropName:string,quantity:number,email:string){
    const headers = new HttpHeaders({
      "Content-Type": "application/json",
      'Authorization': `Basic ${localStorage.getItem('token')}` 
  });

  console.log(quantity + cropName + email+"farmerService")
    return this.http.put(`${this.url}/updateCropDec/${email}/${cropName}/${quantity}`,null,{headers});

  }
  deleteCrop(cropName:string,email:string){
    const headers = new HttpHeaders({
      "Content-Type": "application/json",
      'Authorization': `Basic ${localStorage.getItem('token')}` 
  });
    return this.http.delete(`${this.url}/deleteCrop/${email}/${cropName}`,{headers});

  }
}
