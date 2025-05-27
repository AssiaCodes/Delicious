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
            System.out.println("=== DELI-cious Point of Sale ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                handleNewOrder();
            } else if (choice.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }

    private static void handleNewOrder() throws IOException {
        Order order = new Order();
        while (true) {
            System.out.println("=== Order Menu ===");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

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
                    System.out.println(order.getOrderSummary());
                    ReceiptWriter.createReceiptFile(order.getOrderSummary());
                    System.out.println("Total: $" + order.getTotalPrice());
                    break;

                case "0":
                    System.out.println("Order cancelled.");
                    return;
            }
        }
    }
}

