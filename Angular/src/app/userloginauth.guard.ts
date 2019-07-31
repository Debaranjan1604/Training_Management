import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router,CanActivate } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable()
export class UserloginauthGuard implements  CanActivate {
  
  constructor(private routes : Router){}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot):  boolean {
      if(sessionStorage.getItem('username')!= null && sessionStorage.getItem('role')=='user' ){
        console.log("userguard");
    return true;
      }
      else
      {
        console.log("else userguard");
        this.routes.navigate(['/userlogin']);
        return false;
      }
  }
}
