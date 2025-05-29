package com.pluralsight.models;

import java.util.Scanner;

public class Drink {
    private double price;
    private String size;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Drink(String size, String type)  {
        this.size = size;
        this.type = type;

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

        System.out.println("*★**★*―――― Drinks  ――――*★**★*");
        System.out.println("what size drink do you like?\n" +
                " - small \n" +
                " - medium \n" +
                " - large \n"
        );
        String size = scanner.nextLine();
        System.out.println("Choose a soda type: \n" +
                " - Soda \n" +
                " - Tea \n");
        String type = scanner.nextLine();

        Drink drink = new Drink(size,type);
        return drink;

    }
    public String toString(){
        return "Drink Size: "+size +"\n Drink Type: "+type+" \n Drink Price:  "+"$" + getPrice();

    }
}
