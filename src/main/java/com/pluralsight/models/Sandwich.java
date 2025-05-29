package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Sandwich {
    // Sandwich attributes
    private String breadType;
    private int size;
    private boolean toasted;
    private List<Topping> toppings = new ArrayList<>();
    private double price;
    private boolean extraMeat;
    private boolean extraCheese;

    public boolean isExtraCheese() {
        return extraCheese;
    }


    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }


    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
        if(this.size==4){
            this.price += 0.5;
        }
        if(this.size==8){
            this.price += 1;
        }
        if(this.size==12){
            this.price += 1.5;
        }
    }
    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
        if(this.size==4){
            this.price += 0.30;
        }
        if(this.size==8){
            this.price += 0.60;
        }
        if(this.size==12){
            this.price += 0.90;
        }
    }



    // Builds a sandwich based on user input
    public static Sandwich buildSandwich(Scanner scanner) {
        Sandwich s= new Sandwich();

        // Ask for bread type
        System.out.println("*★**★*―――― Bread choices ――――*★**★*");
        System.out.print("Choose bread:\n" +
                " - white\n" +
                " - wheat\n" +
                " - rye\n" +
                " - wrap\n ");
        s.breadType = scanner.nextLine();


        // Ask for sandwich size
        System.out.println("*★**★*―――― Sandwich sizes ――――*★**★*");
        System.out.print("Choose size:\n" +
                 " - 4\"\n " +
                 " - 8\"\n " +
                 " - 12\"\n ");
        s.size = Integer.parseInt(scanner.nextLine());

         // Ask for cheese topping
        System.out.println("*★**★*―――― Premium toppings ――――*★**★*");
        System.out.println("Choose Meat Toppings:\n" +
                " - Steak \n" +
                " - ham \n" +
                " - salami \n" +
                " - roast beef \n" +
                " - chicken \n" +
                " - bacon \n");
        String meatTopping = scanner.nextLine();
        s.getToppings().add(new Topping(meatTopping,"meat",s.getSize()));

        //
        System.out.print("Add extra meat? (yes/no): ");
        boolean extraMeat = scanner.nextLine().equalsIgnoreCase("yes");
        s.setExtraMeat(extraMeat);

        // Ask for cheese topping
        System.out.println("Choose Cheese Toppings:\n" +
                " - american \n" +
                " - provolone \n" +
                " - cheddar \n" +
                " - swiss \n");
        String cheeseTopping = scanner.nextLine();
        s.getToppings().add(new Topping(cheeseTopping,"cheese",s.getSize()));

        System.out.print("Add extra cheese? (yes/no): ");
        boolean extraCheese = scanner.nextLine().equalsIgnoreCase("yes");
        s.setExtraCheese(extraCheese);


        // Ask for regular toppings
        System.out.println("*★**★*―――― Regular toppings ――――*★**★*");
        System.out.println("Choose Toppings: \n" +
                " - lettuce \n" +
                " - peppers \n" +
                " - onions \n" +
                " - tomatoes \n" +
                " - jalapeños \n" +
                " - cucumbers \n" +
                " - pickles \n" +
                " - guacamole \n" +
                " - mushrooms ");
        String regularTopping = scanner.nextLine();
        s.getToppings().add(new Topping(regularTopping,"regular",s.getSize()));

        // Ask for sauce
        System.out.println("Choose Sauce:\n" +
                " - mayo \n" +
                " - mustard \n" +
                " - ketchup \n" +
                " - ranch \n" +
                " - thousand islands \n" +
                " - vinaigrette "
               );

        String sauce = scanner.nextLine();
        s.getToppings().add(new Topping(sauce,"sauce",s.getSize()));

        // Ask if the sandwich should be toasted
        System.out.println("*★**★*―――― *★**★* ――――*★**★*");
        System.out.print("Toasted? (yes/no): ");
        s.toasted = scanner.nextLine().equalsIgnoreCase("yes");

        return s;

    }
    // Getters and setters
        public String getBreadType () {
            return breadType;
        }

        public void setBreadType (String breadType){
            this.breadType = breadType;
        }

        public int getSize () {
            return size;
        }

        public void setSize ( int size){
            this.size = size;
        }

        public boolean isToasted () {
            return toasted;
        }

        public void setToasted ( boolean toasted){
            this.toasted = toasted;
        }

        public List<Topping> getToppings () {
            return toppings;
        }

        public void addToppings (Topping topping){
            this.toppings.add(topping);
        }


        // Calculates total sandwich price
        public double getPrice() {

            if (this.size == 4) {
                price = price + 5.5;
            }
            if (this.size == 8) {
                price = price + 7.00;
            }
            if (this.size == 12) {
                price = price + 8.50;
            }
            for(Topping topping:this.getToppings()){
                price =price+topping.getPrice();
            }
            return price;
        }
    // Creates a summary of the sandwich details
    @Override
    public String toString() {
        String sandwichSummary=
                "BreadType " + " : " +this.breadType+ "\n"+
                        "Size "+" : "+this.size  +" inches \n"+
                        "Toasted "+" : "+this.toasted  +"\n";
        for(Topping topping: this.toppings){
            sandwichSummary = sandwichSummary + topping+"\n";
        }
        sandwichSummary = sandwichSummary + "Extra Meat: "+this.extraMeat+"\n";
        sandwichSummary = sandwichSummary + "Extra Cheese: "+this.extraCheese+"\n";
        sandwichSummary = sandwichSummary + "Sandwich Price: $"+this.price +"\n";
        return sandwichSummary;
    }
}





