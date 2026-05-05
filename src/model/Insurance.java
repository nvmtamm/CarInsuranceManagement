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
public class Insurance {
    /*
    Fields:
    •	Insurance id: Insurance contract number.  
    •	Lisence plate: License plate of the vehicle is registered for insurance 
    •	Established date: Effective date of insurance. 
    •	Insurance period: integer number. 
    •	Insurance fees: Amount payable for the respective insurance statement. 
    •	Insurance owner: Name of the beneficiary Validation Rules: 
    */
    private String insuranceId;
    private String owner;
    private String lisencePlate;
    private LocalDate establishedDate;
    private int period;
    private String fees;
    
    //Constructor

    public Insurance() {
    }

    public Insurance(String insuranceId, String owner, String lisencePlate, LocalDate establishedDate, int period, String fees) {
        this.insuranceId = insuranceId;
        this.owner = owner;
        this.lisencePlate = lisencePlate;
        this.establishedDate = establishedDate;
        this.period = period;
        this.fees = fees;
    }
    
    //All of getters

    public String getInsuranceId() {
        return insuranceId;
    }

    public String getOwner() {
        return owner;
    }

    public String getLisencePlate() {
        return lisencePlate;
    }

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public int getPeriod() {
        return period;
    }

    public String getFees() {
        return fees;
    }
    
    //All of setters

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setLisencePlate(String lisencePlate) {
        this.lisencePlate = lisencePlate;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }
    
}
