package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Sandwich {
    private String breadType;
    private int size;
    private boolean toasted;
    private List<Topping> toppings = new ArrayList<>();
    private double price;

    public static Sandwich buildSandwich(Scanner scanner) {
        Sandwich s= new Sandwich();
        System.out.println("*★**★*―――― Bread choices ――――*★**★*");
        System.out.print("Choose bread:\n" +
                " - white\n" +
                " - wheat\n" +
                " - rye\n" +
                " - wrap\n ");
        s.breadType = scanner.nextLine();

        System.out.println("*★**★*―――― Sandwich sizes ――――*★**★*");
        System.out.print("Choose size:\n" +
                 " - 4\"\n " +
                 " - 8\"\n " +
                 " - 12\"\n ");
        s.size = Integer.parseInt(scanner.nextLine());


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

        System.out.println("Choose Cheese Toppings:\n" +
                " - american \n" +
                " - provolone \n" +
                " - cheddar \n" +
                " - swiss \n");
        String cheeseTopping = scanner.nextLine();
        s.getToppings().add(new Topping(cheeseTopping,"cheese",s.getSize()));

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

        System.out.println("*★**★*―――― *★**★* ――――*★**★*");

        System.out.print("Toasted? (yes/no): ");
        s.toasted = scanner.nextLine().equalsIgnoreCase("yes");


        return s;
    }



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

    @Override
    public String toString() {
        String sandwichSummary=
                "BreadType " + " : " +this.breadType+ "\n"+
                        "Size "+" : "+this.size  +" inches \n"+
                        "Toasted "+" : "+this.toasted  +"\n";
        for(Topping topping: this.toppings){
            sandwichSummary = sandwichSummary + topping+"\n";
        }
        sandwichSummary = sandwichSummary + "Sandwich Price: $"+this.price +"\n";
        return sandwichSummary;
    }
}





