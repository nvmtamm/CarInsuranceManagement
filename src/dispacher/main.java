/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dispacher;

import bussiness.InsuranceManagement;
import bussiness.VehicleManagement;
import java.util.ArrayList;
import java.util.List;
import model.Insurance;
import model.Vehicle;
import tools.Inputter;


/**
 *
 * @author khach
 */
public class main {
    public static void main(String[] args) {
        VehicleManagement vm = new VehicleManagement("vehiclemanagement.txt", true);
        InsuranceManagement im = new InsuranceManagement("insurancemanagement.txt", true);
        Inputter input = new Inputter();
        
        
                
        int choice;
        vm.showAll();
        im.showAll();
        
        
        do {
            System.out.println("\n");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("                                   MENU                                   ");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("1.Add new car\n" +
                                "2.Find a car by license plate \n" +
                                "3.Update car information \n" +
                                "4.Delete car information \n" +
                                "5.Add an insurance statement \n" +
                                "6.List of insurance statements \n" +
                                "7.Report uninsured cars \n" +
                                "8.Save data \n" +
                                "9.Show data \n" +
                                "10.Quit the program" );
            System.out.println("--------------------------------------------------------------------------");
            
            choice = input.getPositiveInt("Enter your choice:");
            switch (choice) {
                case 1:
                    System.out.println("You chosen: 1.Add new car ");
                     Vehicle v1 = input.getCarInfo();
                     if (v1 != null) {
                        vm.addNew(v1);
                        System.out.println("Add new car successfully!!!");
                    }

                    break;
                
                case 2:
                    System.out.println("You chosen:2.Find a car by license plate ");
                    Vehicle v2 = vm.search(input.inputAndLoop("Enter the license plate number of the car they want to search for: ", tools.Acceptable.LICENSE_PLATE));
                    if (v2 != null) {
                        System.out.println(v2.dataToTable());
                    }else{
                        System.out.println("No one matches the search criteria! ");
                    }
                 
                    break;
            
                
                case 3:
                    System.out.println("You chosen:3.Update car information");
                    String licensePlate = input.inputAndLoop("Enter the license plate number of the car they want to update: ", tools.Acceptable.LICENSE_PLATE);
                    Vehicle v = vm.search(licensePlate);
                    if (v != null) {
                        if (im.checkInsurance(licensePlate) ) {
                            System.out.println("This car is already insurance.Return the menu.");
                        }else{
                            v.toString();
                            if (input.getYesNo("Do you wnat to update this car?: ")) {
                                Vehicle newV = input.getCarInfo();
                                if (newV != null) {
                                    vm.update(v, newV);
                                    System.out.println("Update car information successfully!!!");
                                }
                            }else{
                                System.out.println("Return the menu.");
                            }
                        }
                    break;
                
                case 4:
                    System.out.println("You chosen:4.Delete car information");
                    String licensePlate1 = input.inputAndLoop(" Enter the license plate to delete: ", tools.Acceptable.LICENSE_PLATE);
                    Vehicle v3 = vm.search(licensePlate1);
                    
                    if (v3 != null) {
                        if (im.checkInsurance(licensePlate1) ) {
                            System.out.println("This car is already insurance.Return the menu.");
                            break;
                        }else{
                            v3.toString();
                            if (input.getYesNo("   Do you wnat to delete this car?:   ")) {
                                vm.delete(v3);
                            }else{
                                break;
                            }
                        }
                    }else{
                        System.out.println("This car dose not exist!!!");
                    }
                        
                    break;
                
                case 5:
                    System.out.println("You chosen:5.Add an insurance statement  ");
                    Insurance insurance = input.getInsuranceInfo();
                    if (insurance != null) {
                        if (vm.checkExist(insurance.getInsuranceId())) {
                            im.addNew(insurance);
                            System.out.println(" Add an insurance successflly!!!");
                        }else{
                            System.out.println("This Lisence Plate does not exist!!!");
                        }
                    }
                    break;
                
                case 6:
                    System.out.println("You chosen: 6.List of insurance statements");
                           
                    // not
                    break;
                
                case 7:
                    System.out.println("You chosen:7.Report uninsured cars" );
                    List<Vehicle> list = new ArrayList<>();
                    for (Vehicle value : vm.values()) {
                        if (!im.checkInsurance(value.getLicensePlate())) {
                            list.add(value);
                        }
                    }
                    
                    // check List
                    if (list.isEmpty()) {
                        System.out.println("Not found any vehicle!!");
                    }else{
                        for (Vehicle vehicle : list) {
                            System.out.println(vehicle.dataToTable());
                        }
                    }
                    break;
                
                case 8:
                    System.out.println("You chosen:8. Save data");
                    vm.saveToFile("vehiclemanagement.txt");
                    im.saveToFile("insurancemanagement.txt");

                    break;
                case 9:

                    System.out.println("You chosen:9. Show data");
  
                    vm.showAll();
                    im.showAll();
                    break;
                case 10:

                    System.out.println("You chosen:10. Quit program");
                    if (im.isIsSaved() && vm.isIsSaved()) {
                        System.out.println("Thanks!!");
                    }else{
                        System.out.println("Data does not save!!");
                        if (input.getYesNo("Do you wnat to save the data?: ")) {
                             vm.saveToFile("vehiclemanagement.txt");
                            im.saveToFile("insurancemanagement.txt");
                        }else{
                            System.out.println("Data not save. Thanks!");
                        }
                    }
                    
                    break;
                
                default:
                    throw new AssertionError();
            }
        } while (0<= choice && choice<10);
        
    }
}
