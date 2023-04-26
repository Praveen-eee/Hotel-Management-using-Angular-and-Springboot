package com.room.roombooking.model;

import java.time.LocalDate;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "customerinfo")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long Id;

  @Column(name = "name")
  private String Name;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @Column(name = "Dob")
  private LocalDate Dob;

  @Column(name = "emailId")
  private String emailId;

  @Column(name = "userName")
  private String userName;

  @Column(name = "password")
  private String password;

  @Column(name = "identifier")
  private String identifier;

  public Customer() {
  }



  public Customer(long Id, String Name, LocalDate Dob, String emailId, String userName, String password, String identifier) {
    this.Id = Id;
    this.Name = Name;
    this.Dob = Dob;
    this.emailId = emailId;
    this.userName = userName;
    this.password = password;
    this.identifier = identifier;
  }
  


  public long getId() {
    return this.Id;
  }

  public void setId(long Id) {
    this.Id = Id;
  }

  public String getName() {
    return this.Name;
  }

  public void setName(String Name) {
    this.Name = Name;
  }

  public LocalDate getDob() {
    return this.Dob;
  }

  public void setDob(LocalDate Dob) {
    this.Dob = Dob;
  }

  public String getEmailId() {
    return this.emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getIdentifier() {
    return this.identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }
  
  
}
