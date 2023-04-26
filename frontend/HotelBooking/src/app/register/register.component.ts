import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private roomservice:RoomService, private router: Router) {}

  newcustomer : Customer = new Customer();
  reppassword !: string;

  ngOnInit(): void {
  }

  
  onSubmit()
  {
    // this.newcustomer.id = 1;
    this.newcustomer.identifier= "user";
    console.log(this.newcustomer);
    this.savecustomer();
  }

  savecustomer()
  {
    this.roomservice.addcustomer(this.newcustomer).subscribe(data =>{
      console.log(data);
      alert("Account created successfully");
      this.goTologin();
    }, 
    error => console.log(error));
  }
  goTologin()
  {
    this.router.navigate(['/login']);
  }

}
