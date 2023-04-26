import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../booking';
import { Customer } from '../customer';
import { Room } from '../room';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  rooms?: Room[];
  bookings?: Booking[];
  username !: string;
  name !: string;
  Bookedroomno !:number;
  // customerid !:number;
  customer : Customer = new Customer();

  constructor(private roomservice:RoomService, private router: Router,private route :ActivatedRoute) { }

  ngOnInit(): void {

    this.username = this.route.snapshot.params['username'];
    this.getRooms();
    
    this.roomservice.getcustomerByusername(this.username).subscribe(data => 
      {
        this.customer = data;
        this.name  = this.customer.name!;
        console.log(this.name);

        this.roomservice.getbookingByname(this.name).subscribe(data => {
          this.bookings = data;
          console.log(this.bookings);
        });

      }, error => console.log(error)
      );

  }


  getRooms()
  {
    this.roomservice.getRoomList().subscribe(data => {
      this.rooms = data;
    });
  }

  bookroom(roomNumber : number)
  {
    console.log(roomNumber);
    this.Bookedroomno = roomNumber;
    this.router.navigate(['booking',this.username,roomNumber]);
  }


  // getBookings(bookingname : String)
  // {
  //   this.roomservice.getbookingByname(bookingname).subscribe(data => {
  //     this.bookings = data;
  //     console.log(this.bookings);
  //   });
  // }


  // getcustomerByid(customerid : number)
  // {
  //   this.roomservice.getcustomerById(customerid).subscribe(data => {
  //     this.bookedcustomer = data;
  //     console.log(this.bookedcustomer);
  //   });
  // }

  alertmsg()
  {
    alert("Review submitted successfully");
  }

}
