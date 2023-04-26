import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from "@angular/router";
import { Observable } from "rxjs";
import { LoginService } from "./login.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate{

  status: boolean = false;

  constructor(private loginServices: LoginService, private route :Router) {}

  canActivate(
    route: ActivatedRouteSnapshot, 
    router: RouterStateSnapshot
  ): 
  boolean {
    if(this.isloggedIn()){
      return true;
    }
    this.route.navigate(['login']);
    return false;
  }

  public isloggedIn(){
    let status = false;
    if(this.loginServices.loginStatus===true){
      status=true;
    }
    else{
      status=false;
    }
    return status;
  }

}


// canActivate(
//   route: ActivatedRouteSnapshot, 
//   router: RouterStateSnapshot
// ): boolean | Promise<boolean> | Observable<boolean> {
//     return this.loginServices.loginStatus;
// }