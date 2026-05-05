/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author khach
 */
public class Vehicle {
    /*
    Fields:
•	License plate: A unique 9-character string.  
•	Car owner: Name of the person who owns the vehicle. 
•	Phone Number: Owner's phone number. 
•	Car brand: Brand of the vehicle. 
•	The value of the vehicle: The value of the vehicle that the owner has paid for 
•	Registration Date: The date on which the vehicle was registered for traffic 
•	Place of registration: Is the name of a district in Ho Chi Minh City. • 	Number of seats: The number of seats  Validation Rules: 

    */
    private String licensePlate; // the key of HashMap
    private String carOwner;
    private String phoneNumber;
    private  String carBrand;
    private int value;
    private LocalDate registrationDate;
    private String placeOfRegustration;
    private int numberSeats;
    
    
    // Contructor
    public Vehicle() {
    }

    public Vehicle(String licensePlate, String carOwner, String phoneNumber, String carBrand, int value, LocalDate registrationDate, String placeOfRegustration, int numberSeats) {
        this.licensePlate = licensePlate;
        this.carOwner = carOwner;
        this.phoneNumber = phoneNumber;
        this.carBrand = carBrand;
        this.value = value;
        this.registrationDate = registrationDate;
        this.placeOfRegustration = placeOfRegustration;
        this.numberSeats = numberSeats;
    }
    
    // all of getter

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public int getValue() {
        return value;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getPlaceOfRegustration() {
        return placeOfRegustration;
    }

    public int getNumberSeats() {
        return numberSeats;
    }
     // All of setters

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setPlaceOfRegustration(String placeOfRegustration) {
        this.placeOfRegustration = placeOfRegustration;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }
    
    
    // Method overide: toString()
    @Override
    public String toString() {
        return licensePlate + "," + carOwner + "," + phoneNumber + "," + carBrand + "," + value + "," + registrationDate + "," + placeOfRegustration + "," + numberSeats + '}';
    }

    // Use for ShowAll()
      public String dataToTable() {
        return String.format(
        "| %-10s | %-20s | %-12s | %-10s | %-8d | %-12s | %-15s | %-5d |",
        licensePlate,
        carOwner,
        phoneNumber,
        carBrand,
        value,
        registrationDate.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")),
        placeOfRegustration,
        numberSeats
    );
    }
    
    
}
