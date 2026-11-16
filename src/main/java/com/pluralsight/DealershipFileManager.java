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
    private static final ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static Dealership dealership;
    public Dealership getDealership() {

         dealership = null;

        try {
            File dataFile = new File(FILE_NAME);

            if (dataFile.createNewFile()) {
                System.out.println("Creating new data file: " + FILE_NAME);
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

            dealership = new Dealership(name, address, phone);

            // Read vehicle information
            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    String[] vehicleParts = line.split("\\|");

                    if (vehicleParts.length != 8) {
                        System.out.println("Skipping bad line: " + line);
                        continue;
                    }

                    int vin = Integer.parseInt(vehicleParts[0]);
                    int year = Integer.parseInt(vehicleParts[1]);
                    String make = vehicleParts[2];
                    String model = vehicleParts[3];
                    String vehicleType = vehicleParts[4];
                    String color = vehicleParts[5];
                    int odometer = Integer.parseInt(vehicleParts[6]);
                    BigDecimal price = new BigDecimal(vehicleParts[7]);

                    Vehicle vehicle = new Vehicle(
                            vin, year, make, model,
                            vehicleType, color, odometer, price
                    );

                    dealership.addVehicle(vehicle);

                } catch (Exception e) {
                    System.out.println("Skipping bad line: " + line);
                }
            }

            reader.close();

        } catch (IOException e) {
            System.err.println("Something went wrong: " + e.getMessage());
            return null;
        }

        return dealership;
    }//get Dealership file

    public void saveDealership(){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(dealership.getName() + "   |   " + dealership.getAddress() +  "   |   " + dealership.getPhone());

            writer.newLine();

            for (Vehicle vehicle : vehicles) {
                writer.write(vehicle.getVin() + "   |   " + vehicle.getYear() + "   |   " + vehicle.getMake()
                        + "   |   " + vehicle.getModel() + "   |   " + vehicle.getVehicleType()
                        + "   |   " + vehicle.getColor() + "   |   " + vehicle.getOdometer() + "   |   " + vehicle.getPrice());
                writer.newLine();

            }

            writer.close();
        } catch (IOException e){
            System.err.println("Something went wrong. " + e.getMessage());
        }
    }//Save to dealership file by rewriting it

}
