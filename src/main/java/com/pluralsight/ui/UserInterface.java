package com.pluralsight.ui;


import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;
import com.pluralsight.util.ReceiptWriter;

import java.io.IOException;
import java.util.*;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        while (true) {
            // Display main menu
            System.out.println("★*★*★* Welcome to DELI-cious\uD83D\uDE0B ★*★*★*");
            System.out.println(" ღ꧁ღ╭⊱ꕥ Home screen  ꕥ⊱╮ღ꧂ღ ");
            System.out.println("1- New Order");
            System.out.println("0- Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();


            if (choice.equals("1")) {
                // Begin a new order
                handleNewOrder();
            }

            else if (choice.equals("0")) {
                // Exit the application
                System.out.println("Thank you for your order. Have a great day\uD83D\uDE0A!");
                return;
            }
        }
    }

    private static void handleNewOrder() throws IOException {
        Order order = new Order();

        // Ask for customer name
        System.out.println("What is the name for your order?");
        String name =scanner.nextLine();
        order.setName(name);

        // Display the main order menu options
        while (true) {
            System.out.println("＊☆＊＊☆＊＊ Order Menu ＊＊☆＊＊☆＊");
            System.out.println("1- Add Sandwich");
            System.out.println("2- Add Drink");
            System.out.println("3- Add Chips");
            System.out.println("4- Checkout");
            System.out.println("0- Cancel Order");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            // Order loop for adding items or checking out
            switch (choice) {
                case "1":
                    Sandwich sandwich = Sandwich.buildSandwich(scanner);
                    order.addSandwich(sandwich);
                    break;

                case "2":
                    Drink drink = Drink.orderDrink(scanner);
                    order.addDrink(drink);
                    break;

                case "3":
                    Chips chips = Chips.orderChips(scanner);
                    order.addChips(chips);
                    break;

                case "4":
                    // show summary and confirm
                    System.out.println("*★**★*―――― Checkout ――――*★**★*");
                    System.out.println(order.getOrderSummary());
                    System.out.println("*★**★*―――― Review Your Order ――――*★**★*");
                    System.out.println("Please review and confirm your order selection.");
                    System.out.println("1- Confirm");
                    System.out.println("2- Cancel");

                    String input = scanner.nextLine();
                    if(input.equalsIgnoreCase("1")){
                        // Confirm order and write receipt
                        ReceiptWriter.createReceiptFile(order.getOrderSummary());
                        System.out.println( "Thank you! Your order is confirmed✅");
                        return;
                    }
                     else if(input.equalsIgnoreCase("2")){
                        // Cancel confirmed order
                        System.out.println("Order Cancelled");
                        System.out.println("Good bye!");
                        return;
                    }

                    break;

                case "0":
                    // Cancel and return to home
                    System.out.println("Order cancelled.");
                    return;
            }
        }
    }
}

