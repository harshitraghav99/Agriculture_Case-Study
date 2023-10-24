import { Component } from '@angular/core';
import { Crop } from 'src/app/models/crop';
import { CartService } from 'src/app/services/cart.service';
import { DealerService } from 'src/app/services/dealer.service';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent {

  constructor(private dealerService:DealerService, private cartService : CartService){

  }
  total:number=0;
  crops:Crop[]=[]
  ngOnInit(){
    this.getCart();
  }
  getCart(){
    const email=this.dealerService.getDealerEmail(this.dealerService.getToken())

    this.cartService.getCart(email).subscribe({
      next:(response:Crop[])=>{
        this.crops=response;
        this.crops.forEach(crop => {
          console.log(crop.cropqnty)
          this.total+=Number(crop.cropqnty)
        });
      },
      error:(error:any)=>{
        console.log(error);
        
      }
    })

  }
}
