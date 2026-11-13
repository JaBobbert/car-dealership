package com.pluralsight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

/*
getDealership - Pulls up stored files of dealership
saveDealership - saves data to a file from the dealership
 */
public class DealershipFileManager {
    private  static final String FILE_NAME = "inventory.csv";
    private static final ArrayList<Vehicle> vehicles = new ArrayList<>();

    public Dealership getDealership(String fileName){
        try{
            File dataFile = new File(fileName);
            if(dataFile.createNewFile()){
                System.out.println("Creating new data file: " + fileName);
            }
            BufferedReader reader = new BufferedReader(new FileReader(dataFile));
            String line;
            while ((line = reader.readLine()) != null){
                if(line.trim().isEmpty()){
                    continue;
                }
                try{
                    String[] parts = line.split("\\|");

                    if (parts.length != 8){
                        System.out.println("Skipping line: " + line);
                        continue;
                    }

                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    String color = parts[5];
                    int odometer = Integer.parseInt(parts[6]);
                    BigDecimal price = new BigDecimal(parts[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    vehicles.add(vehicle);
                } catch (Exception e) {
                    System.out.println("Skipping bad line " + line);
                }
                reader.close();
            }
            }catch (IOException e){
            System.err.print("Something went wrong " + e.getMessage());
            return null;
        }
        return getDealership(fileName);
    }//get Dealership file

    public static void saveDealership(String fileName){

    }

}
