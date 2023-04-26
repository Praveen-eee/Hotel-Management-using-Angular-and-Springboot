package com.room.roombooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.room.roombooking.model.Customer;


//@Repository
public interface Customerrepository extends JpaRepository<Customer,Long>{

  // @Query("from customerinfo cus where cus.userName=?1")
     Customer findByuserName(String userName);
}
