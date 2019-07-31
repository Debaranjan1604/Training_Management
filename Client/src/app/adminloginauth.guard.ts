import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router, CanActivate } from '@angular/router';
import { Observable } from 'rxjs';


@Injectable()

export class AdminloginauthGuard implements CanActivate {
  
  constructor(private routes : Router){}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot):  boolean {
      if(sessionStorage.getItem('username')!= null && sessionStorage.getItem('role')=='admin' ){
        return true;
          }
          else
          {
            this.routes.navigate(['/adminlogin']);
        return false;
      }
  }
}
