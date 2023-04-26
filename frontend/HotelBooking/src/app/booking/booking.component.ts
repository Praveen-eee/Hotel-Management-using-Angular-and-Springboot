import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../booking';
import { Customer } from '../customer';
import { Room } from '../room';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  RoomNumber!:number;
  userName!:String;
  room : Room = new Room();
  customer : Customer = new Customer();
  booking : Booking = new Booking();
  sendname ?: String;

  constructor(private roomservice : RoomService,private router : Router,private route :ActivatedRoute) { }

  ngOnInit(): void {

    this.userName = this.route.snapshot.params['username'];
    this.RoomNumber = this.route.snapshot.params['id'];

    console.log(this.RoomNumber,this.userName);
    this.roomservice.getRoomByRoomNo(this.RoomNumber).subscribe(data => 
      {
        this.room = data;
        console.log(this.room);


        //update the bookedroom availabilit to 0
        this.roomservice.updatedbookedroom(this.RoomNumber,0).subscribe(data =>{
          //console.log(data);
        }, 
        error => console.log(error));
      }, error => console.log(error)
      );
    
    this.roomservice.getcustomerByusername(this.userName).subscribe(data => 
      {
        this.customer = data;
        console.log(this.customer);
      }, error => console.log(error)
      );
  }

  onSubmit(bookform: NgForm)
  {
    //console.log(bookform);
    this.booking = bookform.value;
    this.booking.roomNumber = this.RoomNumber;
    console.log(this.booking);
    this.newbooking();
    alert("Room booked sucessfully");
    // addform.reset();
  }

  newbooking()
  {
    this.roomservice.newbooking(this.booking).subscribe(data =>{
      console.log(data);
      this.sendname = this.booking.name;
      //console.log(this.sendname);
      this.goToUser();
    }, 
    error => console.log(error));

    // this.roomservice.updatedbookedroom(this.RoomNumber).subscribe(data =>{
    //   //console.log(data);
    //   //this.goToUser();
    // }, 
    // error => console.log(error));
  }

  goToUser()
  {
    this.router.navigate(['/user',this.userName]);
  }




 


  

}
