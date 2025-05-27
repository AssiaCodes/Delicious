package com.pluralsight.models;

import java.util.Scanner;

public class Drink {
    private double price;
    private String size;

    public Drink(String size) {
        this.size = size;
    }
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

        System.out.println("what size drink do you like? ");
        String size = scanner.nextLine();
        Drink drink = new Drink(size);
        return drink;
    }

    public String toString(){
        return "Drink Size: "+size +" "+getPrice();

    }
}
