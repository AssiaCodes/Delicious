package com.pluralsight.models;

import java.util.Scanner;

public class Chips {
    private double price;

    public static Chips orderChips(Scanner scanner) {


        Chips chips = new Chips();
        return chips;
    }

    public double getPrice(){
        return 1.5;
    }

    @Override
    public String toString() {
        return "Chips: "+getPrice();
    }
}
