/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussiness;


import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import model.Insurance;
import tools.DateUtils;
import tools.FileUtils;

/**
 *
 * @author khach
 */
public class InsuranceManagement extends HashMap<String, Insurance>implements Workable<Insurance>{
    // all of fiels:
    private String pathFile;
    private boolean isSaved;
    private static final String TABLE_HEADER =
    "------------------------------------------------------------------------------------------\n" +
    String.format("| %-6s | %-20s | %-10s | %-12s | %-6s | %-10s |\n",
            "ID", "Owner", "Plate", "Date", "Period", "Fees") +
    "------------------------------------------------------------------------------------------";

    private static final String TABLE_FOOTER =
    "------------------------------------------------------------------------------------------";
    
    // Constructors

    public InsuranceManagement() {
    }

    public InsuranceManagement(String pathFile, boolean isSaved) {
        this.pathFile = pathFile;
        this.isSaved = isSaved;
        this.readFromFile(pathFile);
    }
    
    // All of getter and setter

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
    
    //=================================== Method implement Interface: Workable===========================
     @Override
    public Insurance dataToObject(String data) {
       String[] dataObject = data.split(",");
       
         if (dataObject.length == 6) {
                     String insuranceId = dataObject[0]; // the Key of HashMap
                     String owner = dataObject[1];
                     String lisencePlate = dataObject[2];
                     LocalDate establishedDate = DateUtils.parse(dataObject[3]);
                     int period = Integer.parseInt(dataObject[4]);
                     String fees = dataObject[5];
                     return new Insurance(insuranceId, owner, lisencePlate, establishedDate, period, fees);
         }
         return null;
         
    }

    @Override
    public void readFromFile(String pathFile) {
        List<String> data = FileUtils.loadFromFile(pathFile);
        
        for (String string : data) {
            this.addNew(this.dataToObject(string));
        }
    }

    @Override
    public void saveToFile(String pathFile) {
        FileUtils.saveToFile(pathFile, this.values());
        this.setIsSaved(false);
    }

    @Override
    public void addNew(Insurance x) {
        if (x != null) {
            this.putIfAbsent(x.getInsuranceId(), x);
        }
    }

    
   
    @Override
    public void showAll() {
        this.showAll(this.values());
    }

    @Override
    public void showAll(Collection<Insurance> l) {
        System.out.println(TABLE_HEADER);
        for (Insurance insurance : l) {
            System.out.println(insurance.dataToTable());
        }
        System.out.println(TABLE_FOOTER);
    }
    
     @Override
    public void delete(Insurance x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Insurance search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public void addListToMap(List<Insurance> data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    @Override
    public boolean checkExist(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean checkInsurance(String licensePlate1) {
         for (Insurance insurance : this.values()) {
             if (insurance.getLisencePlate().equalsIgnoreCase(licensePlate1)) {
                 return true;
             }
             
    }
         return false;
    }
    
}
