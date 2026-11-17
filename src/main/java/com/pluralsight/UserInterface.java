package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    private DealershipFileManager dealershipFileManager;
    private static Scanner scan = new Scanner(System.in);

    public void display() {
        init();

        if (dealership == null) {
            System.out.println("Could not load dealership.");
            return;
        }

        while (true) {
            System.out.println();
            System.out.println(dealership.toString());
            System.out.println("\nDealership Menu");
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

            switch (choice) {
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
                    addVehicle();
                    break;

                case "9":
                    removeVehicle();
                    break;

                case "0":
                    dealershipFileManager.saveDealership(dealership);
                    return;

                default:
                    System.out.println("Sorry, wrong choice. Try again.");
                    break;
            }
        }
    }

    // Load dealership from file
    private void init() {
        dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();
    }

    // Display all vehicles
    public void displayAllVehicles() {
        displayVehicles(dealership.getAllVehicles());
    }

    // Reusable display method
    private void displayVehicles(ArrayList<Vehicle> vehicles) {

        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    // Search by price
    public void getByPrice() {
        System.out.println("What is the minimum $");
        double min = scan.nextDouble();

        System.out.println("What is the maximum $");
        double max = scan.nextDouble();
        scan.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehicleByPrice(min, max);
        displayVehicles(vehicles);
    }

    // Search by make and model
    public void getByMakeModel() {
        System.out.println("What make is the vehicle?");
        String make = scan.nextLine();

        System.out.println("What model is the vehicle?");
        String model = scan.nextLine();

        ArrayList<Vehicle> vehicles =
                dealership.getVehicleByMakeModel(make, model);

        displayVehicles(vehicles);
    }

    // Search by year
    public void getByYear() {
        System.out.println("What year to start with?");
        int min = scan.nextInt();

        System.out.println("What year to end with?");
        int max = scan.nextInt();
        scan.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehicleByYear(min, max);
        displayVehicles(vehicles);
    }

    // Search by color
    public void getByColor() {
        System.out.println("What color vehicle are you picking?");
        String color = scan.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehicleByColor(color);
        displayVehicles(vehicles);
    }

    // Search by mileage
    public void getByMilage() {
        System.out.println("What is the minimum mileage?");
        int min = scan.nextInt();

        System.out.println("What is the maximum mileage?");
        int max = scan.nextInt();
        scan.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehicleByMileage(min, max);
        displayVehicles(vehicles);
    }

    // Search by vehicle type
    public void getByVehicleType() {
        System.out.println("What vehicle type is it? (SUV, Car, etc.)");
        String vehicleType = scan.nextLine();

        ArrayList<Vehicle> vehicles =
                dealership.getVehicleByType(vehicleType);

        displayVehicles(vehicles);
    }

    // Add vehicle
    public void addVehicle() {
        System.out.print("What is the VIN number? ");
        int vin = scan.nextInt();
        scan.nextLine();

        System.out.print("What year is this vehicle? ");
        int year = scan.nextInt();
        scan.nextLine();

        System.out.print("What make is this vehicle? ");
        String make = scan.nextLine();

        System.out.print("What model is this vehicle? ");
        String model = scan.nextLine();

        System.out.print("What vehicle type is this? ");
        String vehicleType = scan.nextLine();

        System.out.print("What color is this vehicle? ");
        String color = scan.nextLine();

        System.out.print("What is the mileage? ");
        int odometer = scan.nextInt();
        scan.nextLine();

        System.out.print("What is the price? $");
        BigDecimal price = scan.nextBigDecimal();
        scan.nextLine();

        Vehicle vehicle = new Vehicle(
                vin, year, make, model,
                vehicleType, color, odometer, price
        );

        dealership.addVehicle(vehicle);
    }

    // Remove vehicle
    public void removeVehicle() {
        System.out.print("What is the VIN number? ");
        int vin = scan.nextInt();
        scan.nextLine();

        Vehicle vehicleToRemove = null;

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);
        } else {
            System.out.println("Vehicle not found.");
        }
    }
}
