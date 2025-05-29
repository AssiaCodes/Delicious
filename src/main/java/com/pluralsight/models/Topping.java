package com.pluralsight.models;



public class Topping {
    private String name;
    private int size;
    private String type;

    // Constructor to create a topping with name, type, and sandwich size
    public Topping(String name, String type, int size) {
        this.name = name;
        this.size = size;
        this.type = type;

    }


    // Calculates the price of the topping based on its name and sandwich size
    public double getPrice(){
        if(this.name.equalsIgnoreCase("steak") ||
                this.name.equalsIgnoreCase("ham") ||
                this.name.equalsIgnoreCase("salami") ||
                this.name.equalsIgnoreCase("roast beef") ||
                this.name.equalsIgnoreCase("chicken") ||
                this.name.equalsIgnoreCase("bacon")){
            if(this.size == 4){
                return  1;
            }
            if(this.size == 8){
                return  2;
            }
            if(this.size == 12){
                return  3;
            }
        }


        if(this.name.equalsIgnoreCase("american") ||
                this.name.equalsIgnoreCase("provolone") ||
                this.name.equalsIgnoreCase("cheddar") ||
                this.name.equalsIgnoreCase("swiss")
                ){
            if(this.size == 4){
                return  0.75;
            }
            if(this.size == 8){
                return  1.50;
            }
            if(this.size == 12){
                return  2.25;
            }
        }
        return 0;
    }

    // Returns a string representation of the topping for receipt or display
    @Override
    public String toString() {
        return this.type +"-"+ this.name+ " : $"+getPrice();
    }
}


