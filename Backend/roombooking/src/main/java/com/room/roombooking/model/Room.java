package com.room.roombooking.model;

import java.time.LocalDate;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "roominfo")
public class Room {

  @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long roomNumber;
  @Column(name = "category")
  private String category;
  @Column(name = "roomType")
  private String roomType;
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @Column(name = "arrivalDate")
  private LocalDate arrivalDate;
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @Column(name = "departDate")
  private LocalDate departDate;
  @Column(name = "noOfGuests")
  private int noOfGuests;
  @Column(name = "price")
  private double price;
  @Column(name = "availability")
  private int availability;

  public Room() {
  }

  public Room(long roomNumber, String category, String roomType, LocalDate arrivalDate, LocalDate departDate, int noOfGuests, double price, int availability) {
    this.roomNumber = roomNumber;
    this.category = category;
    this.roomType = roomType;
    this.arrivalDate = arrivalDate;
    this.departDate = departDate;
    this.noOfGuests = noOfGuests;
    this.price = price;
    this.availability = availability;
  }


  public long getRoomNumber() {
    return this.roomNumber;
  }

  public void setRoomNumber(long roomNumber) {
    this.roomNumber = roomNumber;
  }

  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getRoomType() {
    return this.roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  public LocalDate getArrivalDate() {
    return this.arrivalDate;
  }

  public void setArrivalDate(LocalDate arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

  public LocalDate getDepartDate() {
    return this.departDate;
  }

  public void setDepartDate(LocalDate departDate) {
    this.departDate = departDate;
  }

  public int getNoOfGuests() {
    return this.noOfGuests;
  }

  public void setNoOfGuests(int noOfGuests) {
    this.noOfGuests = noOfGuests;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getAvailability() {
    return this.availability;
  }

  public void setAvailability(int availability) {
    this.availability = availability;
  }

}
