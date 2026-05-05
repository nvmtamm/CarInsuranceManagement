/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussiness;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import model.Vehicle;
import tools.DateUtils;
import tools.FileUtils;

/**
 *
 * @author khach
 */
public class VehicleManagement extends HashMap<String, Vehicle>implements Workable<Vehicle>{
    private String pathFile;
    private boolean isSaved;
private static final String TABLE_HEADER =
    "----------------------------------------------------------------------------------------------------------------------------\n" +
    String.format("| %-10s | %-20s | %-12s | %-10s | %-8s | %-12s | %-15s | %-5s |\n",
            "Plate", "Owner", "Phone", "Brand", "Value", "Date", "Place", "Seat") +
    "----------------------------------------------------------------------------------------------------------------------------";

private static final String TABLE_FOOTER =
    "----------------------------------------------------------------------------------------------------------------------------";


    // Contructor
    public VehicleManagement() {
    }

    public VehicleManagement(String pathFile, boolean isSaved) {
        this.pathFile = pathFile;
        this.isSaved = isSaved;
        this.readFromFile(pathFile);  
    }
    
    //All of getters and setters

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public boolean isIsSaved() {
        return isSaved;
    }

    public void setIsSaved(boolean isSaved) {
        this.isSaved = isSaved;
    }
  
   //================================= Implement Interface Workable ==================================
    @Override
    public Vehicle dataToObject(String data) {
      String[] dataOfObject = data.split(",");
        if (dataOfObject.length == 8) {
            String licensePlate = dataOfObject[0]; // the key of HashMap
            String carOwner = dataOfObject[1] ;
            String phoneNumber = dataOfObject[2];
            String carBrand = dataOfObject[3];
            int value = Integer.parseInt(dataOfObject[4]);
            LocalDate registrationDate = DateUtils.parse(dataOfObject[5]);
            String placeOfRegustration = dataOfObject[6];
            int numberSeats = Integer.parseInt(dataOfObject[7]);
            
            Vehicle x = new Vehicle(licensePlate, carOwner, phoneNumber, carBrand, value, registrationDate, placeOfRegustration, numberSeats);
            x.toString();
            return new Vehicle(licensePlate, carOwner, phoneNumber, carBrand, value, registrationDate, placeOfRegustration, numberSeats);
            
        }
        return null; 
        
    }
    @Override
    public void readFromFile(String pathFile) {
        List<String> listOject = FileUtils.loadFromFile(pathFile);
        
        //Duyệt list đưa dữ liệu lên mảng
        for (String string : listOject) {
            //Handle data to Object: Vehicle
            Vehicle vehicle = dataToObject(string);
            if (vehicle != null) {
                this.addNew(vehicle);
            }
        }
    }

    @Override
    public void saveToFile(String pathFile) {
        FileUtils.saveToFile(pathFile, this.values());
        this.setIsSaved(false);
    }

    @Override
    public void addNew(Vehicle x) {
        this.putIfAbsent(x.getLicensePlate(), x);
    }



    @Override
    public void showAll() {
       this.showAll(this.values());
    }

    @Override
    public void showAll(Collection<Vehicle> l) {
        System.out.println(TABLE_HEADER);
        for (Vehicle vehicle : l) {
            System.out.println(vehicle.dataToTable());
        }
        
        System.out.println(TABLE_FOOTER);
    }
    
    
   
        @Override
    public void delete(Vehicle x) {
        this.remove(x.getLicensePlate());
    }

    @Override
    public Vehicle search(String id) {
        return this.get(id);
    }



    @Override
    public void addListToMap(List<Vehicle> data) {
        
    }



    @Override
    public boolean checkExist(String id) {
        Vehicle v = this.get(id);
        if (v != null) {
            return false;
            
        }
        return true;
    }


    
    
    
    
    
    
}
