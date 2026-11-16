package com.pluralsight;

/*
name:String
address:String
phone:String
inventory:ArrayList<Vehicle>

Dealership(name address, phone)
getVehiclesByPrice(min,max):List<Vehicle>
getVehiclesByMakeModel(make,model):List<Vehicle>
getVehiclesByYear(min,max):List<Vehicle>
getVehiclesByColor(color):List<Vehicle>
getVehiclesByMileage(min,max):List<Vehicle>
getVehiclesByVehicleType(vehicleType):List<Vehicle>
getAllVehicles():List<Vehicle>
addVehicle(vehicle)
removeVehicle(vehicle)
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Dealership {
    private String name;
    private String address;
    private String phone;

     public static final ArrayList<Vehicle> inventory = new ArrayList<>();
     private static Vehicle vehicle;
     private static Scanner scanner;

    public Dealership(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static void getVehicleByPrice(double min, double max){
        System.out.println("What is the minimum $");
        min = scanner.nextDouble();
        System.out.println("What is the maximum $");
        max = scanner.nextDouble();
        scanner.nextLine();


        if(vehicle.getPrice().compareTo(BigDecimal.valueOf(min)) >=0 && vehicle.getPrice().compareTo(BigDecimal.valueOf(max)) <=0) {
            System.out.println(vehicle);
        }

    }
    public static void getVehicleByMakeModel(String make, String model, Scanner scanner){
        System.out.println("What make is the vehicle?");
        make = scanner.nextLine();
        System.out.println("What model is the vehicle?");
        model = scanner.nextLine();

        if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
            System.out.println(vehicle);
        }

    }
    public static void getVehicleByYear(int min, int max){
        System.out.println("What year to start with?");
        min = scanner.nextInt();
        System.out.println("What year to end with?");
        max = scanner.nextInt();
        scanner.nextLine();


        if(vehicle.getYear() > min && vehicle.getYear() < max) {
            System.out.println(vehicle);
        }
    }
    public static void getVehicleByColor(String color){
        System.out.println("What color vehicle are you picking?");
        color = scanner.nextLine();
        if (vehicle.getColor().equalsIgnoreCase(color)) {
            System.out.println(vehicle);
        }


    }
    public static void getVehicleByMileage(int min, int max){
        System.out.println("What is the minimum mileage?");
        min = scanner.nextInt();
        System.out.println("What is the maximum mileage?");
        max = scanner.nextInt();
        scanner.nextLine();


        if(vehicle.getOdometer() > min && vehicle.getOdometer() < max) {
            System.out.println(vehicle);
        }
    }
    public static void getVehicleByType(String vehicleType){
        System.out.println("What vehicle type is it?(SUV, Car...etc)");
        vehicleType = scanner.nextLine();

        if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
            System.out.println(vehicleType);
        }

    }
    public static void getAllVehicles(){
        for (Vehicle cars : inventory) {
            System.out.println(cars);
        }

    }
    public static void addVehicle(Vehicle vehicle){
        System.out.print("What is the vin number? ");
        int vin = scanner.nextInt();
        System.out.print("What year is this vehicle? ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("What make is this vehicle? ");
        String make = scanner.nextLine();
        System.out.print("What model is this vehicle? ");
        String model = scanner.nextLine();
        System.out.print("What vehicle type is this? ");
        String vehicleType = scanner.nextLine();
        System.out.print("What color is this vehicle? ");
        String color = scanner.nextLine();
        System.out.print("What is the mileage? ");
        int odometer = scanner.nextInt();
        scanner.nextLine();
        System.out.print("What is the price? $");
        BigDecimal price = scanner.nextBigDecimal();

        vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        inventory.add(vehicle);
        System.out.println("Successfully added.");
    }
    public static void removeVehicle(Vehicle vehicle){
        System.out.print("What is the vin number? ");
        int vin = scanner.nextInt();
        System.out.print("What year is this vehicle? ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("What make is this vehicle? ");
        String make = scanner.nextLine();
        System.out.print("What model is this vehicle? ");
        String model = scanner.nextLine();
        System.out.print("What vehicle type is this? ");
        String vehicleType = scanner.nextLine();
        System.out.print("What color is this vehicle? ");
        String color = scanner.nextLine();
        System.out.print("What is the mileage? ");
        int odometer = scanner.nextInt();
        scanner.nextLine();
        System.out.print("What is the price? $");
        BigDecimal price = scanner.nextBigDecimal();

        if (vehicle.getVin() == vin && vehicle.getYear() == year && vehicle.getMake().equalsIgnoreCase(make)
                && vehicle.getModel().equalsIgnoreCase(model) && vehicle.getVehicleType().equalsIgnoreCase(vehicleType)
                && vehicle.getColor().equalsIgnoreCase(color) && vehicle.getOdometer() == odometer && vehicle.getPrice() == price);

        System.out.println("Successfully removed from the lot.");
        inventory.remove(vehicle);
    }

    @Override
    public String toString() {
        return name + "   |   " + address + "   |   " + phone;
    }
}