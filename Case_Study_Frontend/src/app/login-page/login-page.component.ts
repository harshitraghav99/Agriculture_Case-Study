import { Component } from '@angular/core';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent {
  credentials={
    username:'',
    password:''
  }
  constructor(private loginService:LoginService){

  }
  onSubmit(){
    
    if((this.credentials.username!='' && this.credentials.password!='')
     && 
    (this.credentials.username!= null && this.credentials.password!= null)){

      console.log(this.credentials);
      this.loginService.doLogin(this.credentials).subscribe({
        next:response=>console.log(response.error.error),
        error:error=>console.log(error)
        
      })
      // console.log(token)
      

    }
    else{
      console.log("fields are empty");
    }
  }

}
