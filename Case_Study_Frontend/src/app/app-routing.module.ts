import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomecomponentComponent } from './homecomponent/homecomponent.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { SignUpPageComponent } from './sign-up-page/sign-up-page.component';
import { FarmerLandingPageComponent } from './farmer-landing-page/farmer-landing-page.component';
import { DealerLandingPageComponent } from './dealer-landing-page/dealer-landing-page.component';
import { AuthGuard } from './services/auth.guard';
import { CartPageComponent } from './cart/cart-page/cart-page.component';

const routes: Routes = [

  {
    path:'home',
    component:HomecomponentComponent,
    pathMatch:'full'
  },
  {
    path:'cart',
    component:CartPageComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]

  },
  {
    path:'',
    component:LoginPageComponent,
    pathMatch:'full'
  },
  {
    path:'signup',
    component:SignUpPageComponent,
    pathMatch:'full'

  },
  {
    path:'farmer',
    component:FarmerLandingPageComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  },
  {
    path:'dealer',
    component:DealerLandingPageComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]

  },
  
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
