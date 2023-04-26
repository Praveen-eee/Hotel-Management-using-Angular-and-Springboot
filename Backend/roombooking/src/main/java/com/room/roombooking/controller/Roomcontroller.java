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
import com.room.roombooking.model.Room;
import com.room.roombooking.repository.Roomrepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping


public class Roomcontroller {

  @Autowired
  private Roomrepository roomrepository;

  //get all rooms
  @GetMapping("/getrooms")
  public List<Room> getAllRooms()
  {
    return roomrepository.findAll();
  }

  //create
  @PostMapping("/addroom")
  public Room creatRoom(@RequestBody Room room){
    return roomrepository.save(room);
  }

 //retriving the infos
 @GetMapping("/room/{id}")
 public ResponseEntity<Room> getRoomById(@PathVariable long id) {
   Room room = roomrepository.findById(id).
                       orElseThrow(() -> new ResourceNotFoundException("Room not existedd for id:"+id));
   return ResponseEntity.ok(room);
 }


 //update the infos
 @PutMapping("/updateroom/{roomNumber}")
 public ResponseEntity<Room> updateRoom(@PathVariable long roomNumber,@RequestBody Room roomdetails) {
   Room room = roomrepository.findById(roomNumber).
                       orElseThrow(() -> new ResourceNotFoundException("Room not existedd for id:"+roomNumber));
   
   room.setCategory(roomdetails.getCategory());
   room.setRoomType(roomdetails.getRoomType());
   room.setArrivalDate(roomdetails.getArrivalDate());
   room.setDepartDate(roomdetails.getDepartDate());
   room.setNoOfGuests(roomdetails.getNoOfGuests());
   room.setPrice(roomdetails.getPrice());
   room.setAvailability(roomdetails.getAvailability());

   Room updatedroom = roomrepository.save(room);
   return ResponseEntity.ok(updatedroom);
 }


 //delete  the employee infos
 @DeleteMapping("/room/{roomNumber}")
 public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long roomNumber){
 
   Room room = roomrepository.findById(roomNumber).
   orElseThrow(() -> new ResourceNotFoundException("Room not existedd for id:"+roomNumber));

   roomrepository.delete(room);
   Map<String,Boolean> response = new HashMap<>();
   response.put("deleted",Boolean.TRUE);
   return ResponseEntity.ok(response);
 }


 //update the bookedroom availability
 @PostMapping("/bookedroom/{roomNumber}")
 public ResponseEntity<Room> bookedRoom(@PathVariable long roomNumber,@RequestBody int newavailability) {
   Room room = roomrepository.findById(roomNumber).
                       orElseThrow(() -> new ResourceNotFoundException("Room not existedd for id:"+roomNumber));
   room.setAvailability(newavailability);
   Room updatedroom = roomrepository.save(room);
   return ResponseEntity.ok(updatedroom);
 }
}

