import { Component } from '@angular/core';
import { Crop } from '../models/crop';
import { FarmerService } from '../services/farmer.service';
import { Farmer } from '../models/farmer';

@Component({
  selector: 'app-farmer-landing-page',
  templateUrl: './farmer-landing-page.component.html',
  styleUrls: ['./farmer-landing-page.component.css']
})
export class FarmerLandingPageComponent {

  constructor(private farmerService:FarmerService){
    // this.farmer=new Farmer();
  }
  crops:Crop[]=[];
  cropTemp:Crop[]=[];
  crop=new Crop();
  // farmer:Farmer;
  cropName='';
  inputValue:any;

  quantityTemp=0;
  quantity:number=0;
  

  ngOnInit():void{
    this.getCrops();
    // this.getFarmer();
    console.log(this.quantity)
   
  }
  addCrops(){
    const email=this.farmerService.getFarmerEmail(this.farmerService.getToken())
    this.crop.farmerEmail=email;

    this.farmerService.addCrops(this.crop).subscribe({
      next:(response:any)=>{
        window.location.reload();
      },
      error:(error:any)=>console.log(error)
    })
  }
  captureInput(event: Event): void {
    this.inputValue = (event.target as HTMLInputElement).value;
  }
  updateCropsIncrease(cropName:any){
    // this.quantity=this.quantityTemp;

    console.log(this.quantity,this.cropName);
    const email=this.farmerService.getFarmerEmail(this.farmerService.getToken());
    this.farmerService.updateCropsIncrease(cropName,this.inputValue,email).subscribe({
      next:(response:any)=>{
        window.location.reload();
      },
      error:(error:any)=>console.log(error)})
  }
  updateCropsDecrease(){

    console.log(this.quantity,this.cropName);
    const email=this.farmerService.getFarmerEmail(this.farmerService.getToken());
    this.farmerService.updateCropsDecrease(this.cropName,this.quantity,email).subscribe({
      next:(response:any)=>{
        console.log(response)
        window.location.reload();
      },
      error:(error:any)=>console.log(error)})
  }
  getCrops():void{
    const email=this.farmerService.getFarmerEmail(this.farmerService.getToken())
    console.log(email)
    this.farmerService.getCrops(email).subscribe({ next:(response:Crop[])=>{
      this.crops=response
      // this.quantity=this.crops.
      // console.log(response)
      // console.log(this.crops)
      this.cropTemp=this.crops
      console.log(this.cropTemp)
    },
    error:(error:any)=>console.log(error)}
    )
  }
  onQuantityChange(crop: Crop): void {
    // This function is called when the quantity of a specific crop changes.
    console.log(`New quantity for ${crop.cropName}: ${crop.cropqnty}`);
  }

  deleteCrop(cropName:string){
    const email=this.farmerService.getFarmerEmail(this.farmerService.getToken())
    this.farmerService.deleteCrop(cropName,email).subscribe({
      next:(response:any)=>{
        window.location.reload();
      },
      error:(error:any)=>console.log(error)})
  }


  

  
}
