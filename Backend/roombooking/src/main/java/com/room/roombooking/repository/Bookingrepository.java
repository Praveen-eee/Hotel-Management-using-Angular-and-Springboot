
package com.room.roombooking.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.room.roombooking.model.Booking;


public interface Bookingrepository extends JpaRepository<Booking,Long>{

  List<Booking> findByname(String name);
  
}
