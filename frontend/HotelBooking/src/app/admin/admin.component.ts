import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Booking } from '../booking';
import { Customer } from '../customer';
import { Room } from '../room';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  rooms?: Room[];
  customers?:Customer[];
  bookings?:Booking[];

  newroom: Room = new Room();

  //used for change the availability of the room
  oldbooking :Booking = new Booking();
  roomnumber !: number;

  
  constructor(private roomservice:RoomService, private router: Router) { }

  ngOnInit(): void {

      // this.roomservice.getRoomList().subscribe(data => {
      //   this.rooms = data;
      // });
      this.getRooms();
      this.getCustomers();
      this.getBookings();
      
  }

  getRooms()
  {
    this.roomservice.getRoomList().subscribe(data => {
      this.rooms = data;
      console.log(this.rooms);
    });
  }

  getCustomers()
  {
    this.roomservice.getCustomerList().subscribe(data => {
      this.customers = data;
      console.log(this.customers);
    });
  }

  getBookings()
  {
    this.roomservice.getBookingList().subscribe(data => {
      this.bookings= data;
      console.log(this.bookings);
    });
  }

  saveRoom()
  {
    this.roomservice.createRoom(this.newroom).subscribe(data =>{
      console.log(data);
      this.getRooms();
      this.goToAdmin();
    }, 
    error => console.log(error));
  }

  goToAdmin()
  {
    this.router.navigate(['/admin']);
  }

  onSubmit(addform: NgForm)
  {
    console.log(this.newroom);
    this.saveRoom();
    alert("Submitted sucessfully");
    addform.reset();
  }

  updateroom(roomNumber: number)
  {
    console.log(roomNumber);
    this.router.navigate(['updateroom',roomNumber]);
    //this.getRooms();
    //this.goToAdmin();
  }

  deleteroom(roomNumber: number)
  {
    this.roomservice.deleteRoom(roomNumber).subscribe(data =>
      {
        console.log(roomNumber);
        alert("Deleted sucessfully");
        this.getRooms();
        this.goToAdmin();
      })
  }

  deletecustomer(Customerid: number)
  {
    this.roomservice.deleteCustomer(Customerid).subscribe(data =>
      {
        console.log(Customerid);
        alert("Deleted sucessfully");
        this.getCustomers();
        this.goToAdmin();
      })
  }


  //deleting and updating the room availabilty
  deleteBooking(Bookingid: number)
  {

    this.roomservice.getBookingById(Bookingid).subscribe(data =>
      {
        this.oldbooking = data;
        console.log(this.oldbooking);
        this.roomnumber = this.oldbooking.roomNumber!;
        console.log(this.roomnumber);
        this.roomservice.updatedbookedroom(this.roomnumber,1).subscribe(data =>
          {
            console.log(data);
          }
          );
        
      });

    this.roomservice.cancelBooking(Bookingid).subscribe(data =>
      {
        console.log(Bookingid);
        alert("Deleted sucessfully");
        this.getBookings();
        this.goToAdmin();
      })

      
  }

}
