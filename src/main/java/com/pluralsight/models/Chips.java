package com.pluralsight.models;

import java.util.Scanner;



// Represents a Chips item that can be added to a customer's order
public class Chips {
    private double price;


    // Prompts the user to decide if they want to add chips to their order
    public static Chips orderChips(Scanner scanner) {
        System.out.println("*★**★*―――― Chips  ――――*★**★*");
        System.out.print("Do you like chips ? (yes/no):\n");


        // This line currently reads input but doesn’t use the result
        scanner.nextLine().equalsIgnoreCase("yes");
        scanner.nextLine().equalsIgnoreCase("no");



        Chips chips = new Chips();
        return chips;
    }
    // Returns the fixed price of chips
    public double getPrice(){
        return 1.5;
    }

    // Returns a string representation of the Chips object for display
    @Override
    public String toString() {
        return "Chips "+" : "+ "$" + getPrice();
    }

}
