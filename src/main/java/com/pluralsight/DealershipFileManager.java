package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;
/*
getDealership - Pulls up stored files of dealership
saveDealership - saves data to a file from the dealership
 */

public class DealershipFileManager {

    private static final String FILE_NAME = "inventory.csv";
    private static Dealership dealership = new Dealership();

    public void getDealership() {

        try {
            File dataFile = new File(FILE_NAME);

            if (dataFile.createNewFile()) {
                System.out.println("Creating new data file: " + FILE_NAME);
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {

                String line;

                while ((line = reader.readLine()) != null) {



                    try {
                        String[] parts = line.split("\\|");

                       if (parts.length != 8){
                           System.out.println("Naw " + line);
                       }
                       else if (parts.length == 3) {
                            String name = parts[0];
                            String address = parts[1];
                            String phone = parts[2];

                            dealership = new Dealership(name, address, phone);
                        }

                        int vin = Integer.parseInt(parts[0].trim());
                        int year = Integer.parseInt(parts[1].trim());
                        String make = parts[2].trim();
                        String model = parts[3].trim();
                        String vehicleType = parts[4].trim();
                        String color = parts[5].trim();
                        int odometer = Integer.parseInt(parts[6].trim());
                        BigDecimal price = new BigDecimal(parts[7].trim());

                        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                    } catch (Exception e) {
                        System.out.println("Could not read vehicle: " + line);
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public void saveDealership() {
        if (dealership == null) {
            System.out.println("No dealership information to save.");
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            writer.write(dealership.getName() + "|" +
                    dealership.getAddress() + "|" +
                    dealership.getPhone());

            writer.newLine();

            for (Vehicle vehicle : dealership.getAllVehicles()) {

                writer.write(vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice());

                writer.newLine();
            }

            System.out.println("Dealership saved successfully.");

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
