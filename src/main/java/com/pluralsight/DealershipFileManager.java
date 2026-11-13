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


    public Dealership getDealership(String fileName) {

        try {
            File dataFile = new File(fileName);

            if (dataFile.createNewFile()) {
                System.out.println("Creating new data file: " + fileName);
            }

            BufferedReader reader = new BufferedReader(new FileReader(dataFile));

            // Read dealership information
            String line = reader.readLine();

            if (line == null) {
                reader.close();
                return null;
            }

            String[] parts = line.split("\\|");

            if (parts.length != 3) {
                reader.close();
                return null;
            }

            String name = parts[0];
            String address = parts[1];
            String phone = parts[2];

            Dealership dealership = new Dealership(name, address, phone);

            // Read vehicle information
            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    String[] carParts = line.split("\\|");

                    if (carParts.length != 8) {
                        System.out.println("Skipping bad line: " + line);
                        continue;
                    }

                    int vin = Integer.parseInt(carParts[0]);
                    int year = Integer.parseInt(carParts[1]);
                    String make = carParts[2];
                    String model = carParts[3];
                    String vehicleType = carParts[4];
                    String color = carParts[5];
                    int odometer = Integer.parseInt(carParts[6]);
                    BigDecimal price = new BigDecimal(carParts[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                    dealership.addVehicle(vehicle);

                } catch (Exception e) {
                    System.out.println("Skipping bad line: " + line);
                }
            }

            reader.close();

            return dealership;

        } catch (IOException e) {
            System.err.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }
//get Dealership file

    public static void saveDealership(String fileName){

    }

}
