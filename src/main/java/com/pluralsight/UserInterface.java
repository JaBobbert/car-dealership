package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Calls dealership class to know the vehicles in it
dealership : Dealership calls to this class to use it for the requests

Display
processGetByPriceRequest()
processGetByMakeModelRequest()
processGetByYearRequest()
processGetByColorRequest()
processGetByMileageRequest()
processGetByVehicleTypeRequest()
processGetAllVehicleRequest()
processAddVehicleRequest()
processRemoveVehicleRequest()
 */
public class UserInterface {
    private Dealership dealership;
    private Scanner scan = new Scanner(System.in);

    public void display(){
        init();

        while(true){
            System.out.println("\n Dealership Menu");
            System.out.println("1 - Find vehicles by price");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage");
            System.out.println("6 - Find vehicles by vehicle type");
            System.out.println("7 - Display all vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("0 - Exit");
            System.out.print("Enter your choice: ");

            String choice = scan.nextLine();

            switch (choice){
                case "1":
                    getByPrice();
                    break;

                case "2":
                    getByMakeModel();
                    break;

                case "3":
                    getByYear();
                    break;

                case "4":
                    getByColor();
                    break;

                case "5":
                    getByMilage();
                    break;

                case "6":
                    getByVehicleType();
                    break;

                case "7":
                    displayAllVehicles();
                    break;

                case "8":
                    removeVehicle();
                    break;

                case "9":
                    addVehicle();
                    break;

                case "0":
                    return;

                default:
                    System.out.println("Sorry wrong choice. Try again.");
                    break;
            }//End of while for choice
        }//End of while for userInterface
    }//End of Display method

    private void init(){
        DealershipFileManager files = new DealershipFileManager();
        this.dealership = files.getDealership("inventory.csv");
    }//Opens the file from the file manager in the other class

    public void displayAllVehicles(){
        dealership.getAllVehicles();
    }//Should call to Dealership which prints out all vehicles

    public void getByPrice(){

    }
    public void getByMakeModel(){

    }
    public void getByYear(){

    }
    public void getByColor(){

    }
    public void getByMilage(){

    }
    public void getByVehicleType(){

    }
    public void addVehicle(){

    }
    public void removeVehicle(){

    }
}
