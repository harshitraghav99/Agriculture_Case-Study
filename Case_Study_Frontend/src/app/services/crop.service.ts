import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CropService {

  constructor(private http:HttpClient) { }
  url="http://localhost:8081/auth";

  getCrops(){
    return 
  }
}
