package com.room.roombooking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.room.roombooking.exception.ResourceNotFoundException;
import com.room.roombooking.model.Booking;
import com.room.roombooking.repository.Bookingrepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping

public class Bookingcontroller {

  @Autowired
  private Bookingrepository bookingrepository;

  //get all Bookings
  @GetMapping("/getbookings")
  public List<Booking> getAllBookings()
  {
    return bookingrepository.findAll();
  }

  //create
  @PostMapping("/book")
  public Booking bookRoom(@RequestBody Booking booking){
    return bookingrepository.save(booking);
  }

  //retriving the infos
  @GetMapping("/booking/{id}")
  public ResponseEntity<Booking> getbookingById(@PathVariable long id) {
    Booking booking = bookingrepository.findById(id).
                       orElseThrow(() -> new ResourceNotFoundException("Booking not existedd for id:"+id));
   return ResponseEntity.ok(booking);
 }
 
   //retriving the booking info by booking username
    @GetMapping("/bookingbyname/{name}")
    public List<Booking> getElementsByname(@PathVariable String name)
    {
      return bookingrepository.findByname(name);
    }

 //update the infos
 @PutMapping("/updatebooking/{bookingno}")
 public ResponseEntity<Booking> updateRoom(@PathVariable long bookingno,@RequestBody Booking bookingdetails) {
   Booking booking = bookingrepository.findById(bookingno).
                       orElseThrow(() -> new ResourceNotFoundException("Booking not existedd for id:"+bookingno));
   

    booking.setCheckin(bookingdetails.getCheckin());
    booking.setCheckout(bookingdetails.getCheckout());
    booking.setNoOfGuests(bookingdetails.getNoOfGuests());
    booking.setRoomtype(bookingdetails.getRoomtype());

    Booking updatedbooking = bookingrepository.save(booking);
    return ResponseEntity.ok(updatedbooking);
  }

  //delete  the booking infos
 @DeleteMapping("/booking/{bookingNo}")
 public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long bookingNo){
 
   Booking booking = bookingrepository.findById(bookingNo).
   orElseThrow(() -> new ResourceNotFoundException("Booking not existedd for id:"+bookingNo));

   bookingrepository.delete(booking);
   Map<String,Boolean> response = new HashMap<>();
   response.put("deleted",Boolean.TRUE);
   return ResponseEntity.ok(response);
 }





  
  
}
