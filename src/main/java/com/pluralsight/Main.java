package com.pluralsight;

public class Main {
    public static void main(String[] args) {

        UserInterface user = new UserInterface();
        DealershipFileManager deal = new DealershipFileManager();
        user.display();
        deal.saveDealership();

    }
}
