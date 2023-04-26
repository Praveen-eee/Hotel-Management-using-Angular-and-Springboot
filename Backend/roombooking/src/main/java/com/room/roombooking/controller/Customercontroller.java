package com.room.roombooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.room.roombooking.exception.ResourceNotFoundException;
import com.room.roombooking.model.Customer;
import com.room.roombooking.repository.Customerrepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping
public class Customercontroller {

  @Autowired
  private Customerrepository customerrepository;

  //get all customers
  @GetMapping("/customers")
  public List<Customer> getAllcustomers()
  {
    return customerrepository.findAll();
  }

  //create
  @PostMapping("/addcustomer")
  public Customer creatcustomer(@RequestBody Customer customer){
    return customerrepository.save(customer);
  }

  //retriving the infos
  @GetMapping("/customer/{id}")
  public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
    Customer customer = customerrepository.findById(id).
                       orElseThrow(() -> new ResourceNotFoundException("Room not existedd for id:"+id));
   return ResponseEntity.ok(customer);
   }

  //update the infos
  @PutMapping("/updatecustomer/{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable long id,@RequestBody Customer customerdetails) {
    Customer customer = customerrepository.findById(id).
                        orElseThrow(() -> new ResourceNotFoundException("Room not existedd for id:"+id));
    customer.setName(customerdetails.getName());
    customer.setDob(customerdetails.getDob());
    customer.setEmailId(customerdetails.getEmailId());
    customer.setUserName(customerdetails.getUserName());
    customer.setPassword(customerdetails.getPassword());
    //customer.setIdentifier("user");
    Customer updatedcustomer = customerrepository.save(customer);
    return ResponseEntity.ok(updatedcustomer);
   }

   //delete  the employee infos
   @DeleteMapping("/customer/{id}")
   public ResponseEntity<Map<String,Boolean>> deleteCustomer(@PathVariable Long id){
 
   Customer customer = customerrepository.findById(id).
   orElseThrow(() -> new ResourceNotFoundException("Customer not existed for id:"+id));

   customerrepository.delete(customer);
   Map<String,Boolean> response = new HashMap<>();
   response.put("deleted",Boolean.TRUE);
   return ResponseEntity.ok(response);
 }


 //verify the username
 @GetMapping("/username/{userName}/{password}")
 public int isValidcustomer(@PathVariable String userName,@PathVariable String password)
 {
  int result;
  Customer customer = customerrepository.findByuserName(userName);
  if(customer == null)
  {
    return 0;
    //throw new ResourceNotFoundException("username not found");
  }

  if(customer.getIdentifier().equalsIgnoreCase("admin") && customer.getPassword().equalsIgnoreCase(password))
    {
      result = 1;
    }

  else if(customer.getIdentifier().equalsIgnoreCase("user") && customer.getPassword().equalsIgnoreCase(password))
    {
      result = 2;
    }
  else
    {
      result = 3;
    }
    return result;
 }

  //get by username
  @GetMapping("/username/{userName}")
  public ResponseEntity<Customer> getElementsByusername(@PathVariable String userName)
  {
    Customer customer = customerrepository.findByuserName(userName);
    return ResponseEntity.ok(customer);
  }

}
