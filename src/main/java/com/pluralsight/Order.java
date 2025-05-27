package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Sandwich> sandwiches = new ArrayList<>();
    List<Drink> drinks = new ArrayList<>();
    List<Chips> chipsList = new ArrayList<>();
    double totalPrice;

    public void addSandwich(Sandwich sandwich){
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

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public List<Sandwich> getSandwiches()
    {
        return sandwiches;
    }

    public List<Drink> getDrinks()
    {
        return drinks;
    }
    public List<Chips> getChips()
    {
        return chipsList;
    }

    public String getOrderSummary(){
        String summary = "";
        for(Sandwich sandwich : this.sandwiches){
            summary += sandwich.toString();
        }
        for (Drink drink : this.drinks){
            summary += drink.toString()+"\n";
        }

        for (Chips chips : this.chipsList){
            summary += chips.toString();
        }
        return summary;
    }
}
