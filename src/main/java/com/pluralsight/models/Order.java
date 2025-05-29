package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    // Lists to store each item in the order
    List<Sandwich> sandwiches = new ArrayList<>();
    List<Drink> drinks = new ArrayList<>();
    List<Chips> chipsList = new ArrayList<>();

    // Total price of the entire order
    double totalPrice;
    // Customer name
    String name;

    // Getter and setter for customer name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Adds a sandwich to the order and updates total price
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
        totalPrice = totalPrice + sandwich.getPrice();
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
        totalPrice = totalPrice + drink.getPrice();
    }

    public void addChips(Chips chips) {
        chipsList.add(chips);
        totalPrice = totalPrice + chips.getPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chipsList;
    }

    // Builds and returns a summary of the entire order for display or receipt
    public String getOrderSummary() {

        String summary = "Order for " + this.name + "\n";
        summary = summary + "****************"+"\n";

        // Add sandwich details
        for (Sandwich sandwich : this.sandwiches) {
            summary += sandwich.toString()+"\n"+ "****************"+"\n";
        }
        for (Drink drink : this.drinks) {
            summary += drink.toString() + "\n";
        }

        for (Chips chips : this.chipsList) {
            summary += chips.toString()+ "\n";
        }

        // Add total price to summary
        summary += "TotalPrice: " + "$" + totalPrice;
        return summary;

    }
}






