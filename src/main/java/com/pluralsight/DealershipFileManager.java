package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
/*
getDealership - Pulls up stored files of dealership
saveDealership - saves data to a file from the dealership
 */






public class DealershipFileManager {

    private static final String FILE_NAME = "inventory.csv";

    // Load dealership information from file
    public Dealership getDealership() {

        Dealership dealership = null;

        try {
            File dataFile = new File(FILE_NAME);

            if (!dataFile.exists()) {
                System.out.println("Inventory file not found.");
                return null;
            }

            try (BufferedReader reader =
                         new BufferedReader(new FileReader(dataFile))) {

                String line = reader.readLine();

                if (line == null) {
                    return null;
                }

                // Read dealership information
                String[] parts = line.split("\\|", -1);

                if (parts.length != 3) {
                    System.out.println("Invalid dealership information.");
                    return null;
                }

                String name = parts[0].trim();
                String address = parts[1].trim();
                String phone = parts[2].trim();

                dealership = new Dealership(name, address, phone);

                // Read vehicles
                while ((line = reader.readLine()) != null) {

                    if (line.trim().isEmpty()) {
                        continue;
                    }

                    try {
                        String[] vehicleParts = line.split("\\|", -1);

                        if (vehicleParts.length != 8) {
                            System.out.println("Skipping bad line: " + line);
                            continue;
                        }

                        int vin = Integer.parseInt(vehicleParts[0].trim());
                        int year = Integer.parseInt(vehicleParts[1].trim());
                        String make = vehicleParts[2].trim();
                        String model = vehicleParts[3].trim();
                        String vehicleType = vehicleParts[4].trim();
                        String color = vehicleParts[5].trim();
                        int odometer = Integer.parseInt(vehicleParts[6].trim());
                        BigDecimal price = new BigDecimal(vehicleParts[7].trim());

                        Vehicle vehicle = new Vehicle(
                                vin, year, make, model,
                                vehicleType, color, odometer, price
                        );

                        // Add vehicle to the actual dealership inventory
                        dealership.addVehicle(vehicle);

                    } catch (Exception e) {
                        System.out.println("Could not read vehicle: " + line);
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        return dealership;
    }

    // Save dealership information to file
    public void saveDealership(Dealership dealership) {

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

            // Get the actual dealership inventory
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
