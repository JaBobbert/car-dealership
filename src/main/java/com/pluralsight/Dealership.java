package com.pluralsight;


import java.math.BigDecimal;
import java.util.ArrayList;
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



public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    // Constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    // Search by price
    public ArrayList<Vehicle> getVehicleByPrice(double min, double max) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice().compareTo(BigDecimal.valueOf(min)) >= 0 &&
                    vehicle.getPrice().compareTo(BigDecimal.valueOf(max)) <= 0) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // Search by make and model
    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) &&
                    vehicle.getModel().equalsIgnoreCase(model)) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // Search by year
    public ArrayList<Vehicle> getVehicleByYear(int min, int max) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // Search by color
    public ArrayList<Vehicle> getVehicleByColor(String color) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // Search by mileage
    public ArrayList<Vehicle> getVehicleByMileage(int min, int max) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min &&
                    vehicle.getOdometer() <= max) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // Search by vehicle type
    public ArrayList<Vehicle> getVehicleByType(String vehicleType) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // Return all vehicles
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    // Add vehicle
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
        System.out.println("Successfully added.");
    }

    // Remove vehicle
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
        System.out.println("Successfully removed from the lot.");
    }

    @Override
    public String toString() {
        return name + "   |   " + address + "   |   " + phone;
    }
}
