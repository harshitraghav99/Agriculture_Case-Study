import { Component } from '@angular/core';

@Component({
  selector: 'app-sign-up-page',
  templateUrl: './sign-up-page.component.html',
  styleUrls: ['./sign-up-page.component.css']
})
export class SignUpPageComponent {
  show = '';
  farmerCredentials={
    farmerName:'',
    farmerEmail:'',
    farmerPassword:'',
    farmerBank:'',
    farmerPaytmId:'',
    farmerAccountNo:'',
    farmerBankBranch:'',
    farmerContact:'',
    farmerLocation:'',
    farmerAbout:''
  }
  dealerCredentials={
    dealerName:'',
    dealerEmail:'',
    dealerPassword:'',
    dealerBank:'',
    dealerPaytmId:'',
    dealerAccountNo:'',
    dealerBankBranch:'',
    dealerContact:'',
    dealerLocation:'',
    dealerAbout:''
  }
  toggleFarmerShow(){
    this.show='farmer';
  }
  toggleDealerShow(){
    this.show='dealer';
  }

  // onSubmit(){
  //   if(this.farmerCredentials.farmerName===null 
  //     &&
  //     this.farmerCredentials.farmerPassword===null
  //     &&
  //     this.farmerCredentials.far)
  // }

  
}
