package com.pluralsight.models;

import java.util.Scanner;


// Represents a drink item in the customer's order

public class Drink {
    private double price;
    private String size;
    private String type;

    // Getter for the drink type
    public String getType() {
        return type;
    }
    // Setter to update the drink type
    public void setType(String type) {
        this.type = type;
    }
    // Constructor that initializes a Drink with size and type
    public Drink(String size, String type)  {
        this.size = size;
        this.type = type;

    }
    // Calculates and returns the price based on drink size
    public double getPrice(){
        if(size.equalsIgnoreCase("small"))
            return  2;
        if(size.equalsIgnoreCase("medium"))
            return 2.50;
        if(size.equalsIgnoreCase("large"))
            return 3;

        return 0;
    }

    public static Drink orderDrink(Scanner scanner) {


        System.out.println("*★**★*―――― Drinks  ――――*★**★*");

        // Ask user for drink size
        System.out.println("what size drink do you like?\n" +
                " - small \n" +
                " - medium \n" +
                " - large \n"
        );
        String size = scanner.nextLine();

        // Ask user for drink type
        System.out.println("Choose a soda type: \n" +
                " - Soda \n" +
                " - Tea \n");
        String type = scanner.nextLine();

        // Create and return a new Drink object
        Drink drink = new Drink(size,type);
        return drink;

    }
    // Returns a string representation of the drink for displaying in order summary
    public String toString(){
        return "Drink Size: "+size +"\n Drink Type: "+type+" \n Drink Price:  "+"$" + getPrice();

    }
}
