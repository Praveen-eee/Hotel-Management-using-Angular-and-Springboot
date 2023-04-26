import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import{Login} from './login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  userId:any;
  loginStatus: boolean = false;

  private apiUrl:string;

  constructor(private http: HttpClient) {
    this.apiUrl = 'http://localhost:4200/login';
  }

  public checkUser(data:Login):Observable<Boolean> {
    return this.http.post<Boolean>(this.apiUrl, data);
  }
  setId(data:any){
    this.userId = data;
  }

}