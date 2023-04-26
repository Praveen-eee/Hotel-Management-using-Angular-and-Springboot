import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminComponent } from '../admin/admin.component';
import { Room } from '../room';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-updateroom',
  templateUrl: './updateroom.component.html',
  styleUrls: ['./updateroom.component.css']
})
export class UpdateroomComponent implements OnInit {

  RoomNumber:number = 2;
  newroom : Room = new Room();
  constructor(private roomservice : RoomService,private router : Router,private route :ActivatedRoute) { }

  ngOnInit(): void {
    this.RoomNumber = this.route.snapshot.params['id'];
    console.log(this.RoomNumber);
    this.roomservice.getRoomByRoomNo(this.RoomNumber).subscribe(data => 
      {
        this.newroom = data;
        console.log(this.newroom);
      }, error => console.log(error)
      );
  }

  onSubmit()
  {
    this.roomservice.updateRoom(this.RoomNumber,this.newroom).subscribe(data =>
      {
        alert("Updated Sucessfully");
      },error => console.log(error)
      );
    this.goToAdmin();
    
  }

  goToAdmin()
  {
    this.router.navigate(['/admin']);
  }

}
