package com.room.roombooking.model;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "bookinginfo")
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long Id;

  @Column(name = "name")
  private String name;

  @Column(name = "emailid")
  private String emailid;
  
  @Column(name = "roomtype")
  private String roomtype;

  @Column(name = "mobno")
  private String mobno;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @Column(name = "checkin")
  private LocalDate checkin;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @Column(name = "checkout")
  private LocalDate checkout;
  
  @Column(name = "noOfGuests")
  private int noOfGuests;

  @Column(name = "roomNumber")
  private long roomNumber;


  public Booking() {
  }


  public Booking(long Id, String name, String emailid, String roomtype, String mobno, LocalDate checkin, LocalDate checkout, int noOfGuests, long roomNumber) {
    this.Id = Id;
    this.name = name;
    this.emailid = emailid;
    this.roomtype = roomtype;
    this.mobno = mobno;
    this.checkin = checkin;
    this.checkout = checkout;
    this.noOfGuests = noOfGuests;
    this.roomNumber = roomNumber;
  }
  


  public long getId() {
    return this.Id;
  }

  public void setId(long Id) {
    this.Id = Id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmailid() {
    return this.emailid;
  }

  public void setEmailid(String emailid) {
    this.emailid = emailid;
  }

  public String getRoomtype() {
    return this.roomtype;
  }

  public void setRoomtype(String roomtype) {
    this.roomtype = roomtype;
  }

  public String getMobno() {
    return this.mobno;
  }

  public void setMobno(String mobno) {
    this.mobno = mobno;
  }

  public LocalDate getCheckin() {
    return this.checkin;
  }

  public void setCheckin(LocalDate checkin) {
    this.checkin = checkin;
  }

  public LocalDate getCheckout() {
    return this.checkout;
  }

  public void setCheckout(LocalDate checkout) {
    this.checkout = checkout;
  }

  public int getNoOfGuests() {
    return this.noOfGuests;
  }

  public void setNoOfGuests(int noOfGuests) {
    this.noOfGuests = noOfGuests;
  }

  public long getRoomNumber() {
    return this.roomNumber;
  }

  public void setRoomNumber(long roomNumber) {
    this.roomNumber = roomNumber;
  }
  
}
