/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import model.Insurance;
import model.Vehicle;


/**
 *
 * @author khach
 */
public class Inputter {
    private Scanner sc;

    //Tao 1 đối tượng scanner
    public Inputter() {
        this.sc = new Scanner(System.in);
    }
/**
 * Method: getString() tích hợp việc vừa lấy dữ liệu là string vừa in ra màn hình message
 * @param message: được in ra màn hình
 * @return 
 */   
    public String getString(String message){
        System.out.print(message);
        return sc.nextLine().trim();
    }
/**
 * Method: getStringWithEmpty cho phép ngươif dùng nhập 1 chuỗi rổng ( Enter) dùng để skip input.
 * @param message
 * @param pattern
 * @return 
 */
    public String getStringWithEmpty(String message, String pattern){
        String result =""; boolean more = true;
        do { 
            result = this.getString(message);
            more = !Acceptable.isValid(result, pattern) && !result.isEmpty();
            
            if (more) {
                System.out.println("Invalid data!! Please input again..");              
            }
            
        } while (more);
        
        return result;
    }
/**
 * Method: getPositiveInt() cho phép người dùng nhập vào 1 string ( must be Integer style)
 * --> kiểm tra validation --> parseInt(result)
 * @param message
 * @return Integer.parseInt(result);
 */
    public int getPositiveInt(String message){
        String result ; boolean more = true;
        do {
            result = this.getString(message);
            more = !Acceptable.isValid(result, Acceptable.POSITIVE_INT_VALID);
            
            if (more) {
                System.out.println("Invalid positive integer. Input again, please.");
            }
            
        } while (more);
        
        return Integer.parseInt(result);
    }
 /**
  * Method: getDate() 
  * @param message
  * @return 
  */
    public LocalDate getDate(String message) {
        String input;
        LocalDate date = null;

        do {
            input = getString(message);

            if (!Acceptable.isValid(input, Acceptable.DATE_VALID)) {
                System.out.println("Wrong format (dd/MM/yyyy)! Re-enter.");
                continue;
            }

            try {
                date = tools.DateUtils.tryParse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date! Re-enter.");
            }

        } while (date == null);

        return date;
    }
    /**
     * 
     * @param message
     * @param pattern
     * @return 
     */
        public String inputAndLoop(String message, String pattern){
        String result =""; boolean more = true;
        do { 
            result = this.getString(message);
            more = !Acceptable.isValid(result, pattern);
            
            if (more) {
                System.out.println("Invalid data!! Please input again..");              
            }
            
        } while (more);
        
        return result;
    }

  /**
 * 
 * @param message
 * @return 
 */
    public boolean getYesNo(String message) {
        String input;
        do {
            input = getString(message + " (Y/N): ");
            if (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
                System.out.println("Please enter Y or N.");
            }
        } while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N"));

        return input.equalsIgnoreCase("Y");
    }
//========================================= All these method for main funtions =======================================

    public Vehicle getCarInfo() {
     String licensePlate = inputAndLoop("     Enter License Plate: ", Acceptable.LICENSE_PLATE); // the key of HashMap
     String carOwner = inputAndLoop("     Enter Car Owner Name: ", Acceptable.CAR_OWNER);
     String phoneNumber = inputAndLoop("     Enter Owner's Phone Number: ", Acceptable.PHONE);
     String carBrand = inputAndLoop("     Enter Car Brand: ", Acceptable.CAR_BRAND);;
     int value = Integer.parseInt(inputAndLoop("     Enter Car's Value: ", Acceptable.VEHICLE_VALUE));
     LocalDate registrationDate = DateUtils.parse(inputAndLoop("     Enter Register Date: ", Acceptable.DATE_VALID));
     String placeOfRegustration = inputAndLoop("     Enter Plae Register: ", Acceptable.PLACE);
     int numberSeats = Integer.parseInt(inputAndLoop("     Number of Seats: ", Acceptable.SEATS));
     
     return new Vehicle(licensePlate, carOwner, phoneNumber, carBrand, value, registrationDate, placeOfRegustration, numberSeats);
    }

    public Insurance getInsuranceInfo() {
            String insuranceId = inputAndLoop("    Enter the Insurance ID: ", Acceptable.INSURANCE_ID); // the Key of HashMap
            String owner = inputAndLoop("    Enter Owner Name: ", Acceptable.INS_OWNER);;
            String lisencePlate = inputAndLoop("    Enter the Insurance Plate: ", Acceptable.LICENSE_PLATE);;
            LocalDate establishedDate = DateUtils.parse( inputAndLoop("    Enter the establishedDate: ", Acceptable.DATE_VALID));
            int period = Integer.parseInt(inputAndLoop("   Enter the Period: ", Acceptable.PERIOD));
            String fees = inputAndLoop("   Enter the fees:  ", Acceptable.FEES);
            
            return  new Insurance(insuranceId, owner, lisencePlate, establishedDate, period, fees);
    }

    
}
