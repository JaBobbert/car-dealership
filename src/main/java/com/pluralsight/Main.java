package com.pluralsight;

public class Main {
    public static void main(String[] args) {

        DealershipFileManager deal = new DealershipFileManager();
        Dealership dealership = deal.getDealership("inventory.csv");
        dealership.getAllVehicles();

    }
}
