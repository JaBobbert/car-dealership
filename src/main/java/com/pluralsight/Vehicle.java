package com.pluralsight;

import java.math.BigDecimal;

/*
Hold information about specific vehicle
Vin:Int
Year:Int
Make:String
Model:String
VehicleType:String(Car, Truck, Suv)
Color:String
Odometer:Int
Price:BigDecimal
vehicleClass(Vin, Year, Make, Model, Type, Color, Odom, Price)
 */
public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private BigDecimal price;


    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, BigDecimal price){
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public int vin() {
        return vin;
    }

    public int year() {
        return year;
    }

    public String make() {
        return make;
    }

    public String model() {
        return model;
    }

    public String vehicleType() {
        return vehicleType;
    }

    public String color() {
        return color;
    }

    public int odometer() {
        return odometer;
    }

    public BigDecimal price() {
        return price;
    }
}
