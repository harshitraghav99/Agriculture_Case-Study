import { Component } from '@angular/core';
import { DealerService } from '../services/dealer.service';
import { Crop } from '../models/crop';

@Component({
  selector: 'app-dealer-landing-page',
  templateUrl: './dealer-landing-page.component.html',
  styleUrls: ['./dealer-landing-page.component.css']
})
export class DealerLandingPageComponent {
  constructor(private dealerService:DealerService){

  }
  inputValue:any;
  crops:Crop[]=[]
  crop=new Crop();
  
  ngOnInit(){
    this.getCrops();
  }

  captureInput(event: Event): void {
    this.inputValue = (event.target as HTMLInputElement).value;
  }
  getCrops():void{
    this.dealerService.getCrops().subscribe({
      next:(response:Crop[])=>{
        this.crops=response
        console.log(response)
      },error:(error:any)=>console.log(error)})
      
  }
  addToCart(cropId:any){
    // console.log(this.crops.f(cropId));
    this.crops.forEach(element => {
      if(element.cropId===cropId){
        console.log(element);
        this.crop=element;
      }
    });
    const email=this.dealerService.getDealerEmail(this.dealerService.getToken())

    this.dealerService.addToCart(this.crop,cropId,this.inputValue,email).subscribe({
      next:(response)=>{

      },
      error:(error:any)=>console.log(error)})
  }

}
