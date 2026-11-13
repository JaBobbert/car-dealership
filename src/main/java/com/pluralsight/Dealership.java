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

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;

     public static final ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String address() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String phone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static void getVehicleByPrice(double min, double max){

    }
    public static void getVehicleByMakeModel(String make, String model){

    }
    public static void getVehicleByYear(double min, double max){

    }
    public static void getVehicleByColor(String color){

    }
    public static void getVehicleByMilage(String make, String model){

    }
    public static void getVehicleByType(String vehicleType){

    }
    public static void getAllVehicle(){
        for (Vehicle cars : inventory) {
            System.out.println(cars);
        }

    }
    public static void addVehicle(Vehicle vehicle){

    }
    public static void removeVehicle(Vehicle vehicle){

    }

}
