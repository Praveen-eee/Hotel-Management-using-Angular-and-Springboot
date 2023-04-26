import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from './booking';
import { Customer } from './customer';
import { Room } from './room';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private baseURL1 = "http://localhost:8080/getrooms"; // getallroom
  private baseURL2 = "http://localhost:8080/addroom";  //addroom
  private baseURL3 = "http://localhost:8080/room";  //retriveroomdata
  private baseURL4 = "http://localhost:8080/updateroom";  //updateroom
  private baseURL5 = "http://localhost:8080/bookedroom"        //update booked room
  

  constructor(private httpClient:HttpClient) { }

  getRoomList(): Observable<Room[]>{
    return this.httpClient.get<Room[]>(`${this.baseURL1}`);
  }

  getCustomerList(): Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(`http://localhost:8080/customers`);
  }


  getBookingList(): Observable<Booking[]>{
    return this.httpClient.get<Booking[]>(`http://localhost:8080/getbookings`);
  }


  createRoom(room:Room):Observable<any>{
    return this.httpClient.post(`${this.baseURL2}`,room);
  }

  getRoomByRoomNo(RoomNumber:number):Observable<Room>{
    return this.httpClient.get<Room>(`${this.baseURL3}/${RoomNumber}`);
  }

  getBookingById(bookingId:number):Observable<Booking>{
    return this.httpClient.get<Booking>(`http://localhost:8080/booking/`+bookingId);
  }


  updateRoom(RoomNumber:number, room: Room):Observable<object>{
    return this.httpClient.put(`${this.baseURL4}/${RoomNumber}`,room);
  }

  deleteRoom(RoomNumber:number): Observable<object>
  {
    return this.httpClient.delete(`${this.baseURL3}/${RoomNumber}`);
  }

  deleteCustomer(customerid:number): Observable<object>
  {
    return this.httpClient.delete(`http://localhost:8080/customer/`+customerid);
  }

  cancelBooking(bookingid:number): Observable<object>
  {
    return this.httpClient.delete(`http://localhost:8080/booking/`+bookingid);
  }

  checkvaliduser(userName:string,password:string): Observable<number>
  {
    return this.httpClient.get<number>('http://localhost:8080/username/'+userName+'/'+password);
  }

  addcustomer(customer:Customer):Observable<any>{
    return this.httpClient.post('http://localhost:8080/addcustomer',customer);
  }

  getcustomerByusername(userName:String):Observable<Customer>
  {
    return this.httpClient.get<Customer>('http://localhost:8080/username/'+userName);
  }

  newbooking(booking:Booking):Observable<any>{
    return this.httpClient.post('http://localhost:8080/book',booking);
  }


  // updatebookedroom(RoomNumber:number):Observable<object>{
  //   return this.httpClient.post(`http://localhost:8080/bookedroom/`+RoomNumber);
  // }


  updatedbookedroom(roomnumber:number,availabilty:number):Observable<any>{
    return this.httpClient.post('http://localhost:8080/bookedroom/'+roomnumber,availabilty);
  }

  getbookingByname(bookingname:string):Observable<Booking[]>{
    return this.httpClient.get<Booking[]>('http://localhost:8080/bookingbyname/'+bookingname);
  }


  getcustomerById(customerid :number):Observable<Customer>{
    return this.httpClient.get<Customer>(`http://localhost:8080/customer/`+customerid);
  }

}
