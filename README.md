# DELI-cious App

Welcome to DELI-cious  
System – a Java-based console application for managing orders at a customizable sandwich shop.

## Project Description

This application was built as a capstone project to simulate a real-world POS system.
DELI-cious customers can create fully customized sandwiches,
choose drinks and chips, and receive a complete receipt of their order. 
This system is designed with Object-Oriented Programming (OOP) principles and file-based persistence.

## Features

- Sandwich customization (bread type, size, toppings, toasting)
- Support for premium and extra toppings
- Add drinks and chips to orders
- Live order summary and cost calculation
- Receipt generation with timestamped filenames
- Console-based UI

## Screenshots
Home Screen

![image](https://github.com/user-attachments/assets/99b8dc26-b882-43e6-9cfc-744c23c70930)

Order Menu

![image](https://github.com/user-attachments/assets/a03ce6d0-8564-49a2-8037-d7458a759589)

Add Sandwich

![image](https://github.com/user-attachments/assets/4e70dfa0-0def-42f9-8593-9b44bcf50efe)

![image](https://github.com/user-attachments/assets/d08f4a38-451e-420f-b967-f90496e7b4be)

![image](https://github.com/user-attachments/assets/fb158e32-24a5-4ef5-9d56-8abf97d1fe5a)

Add Drink 

![image](https://github.com/user-attachments/assets/c89b2a06-a3cf-440c-9a45-7334d79b3a8b)

Add Chips

![image](https://github.com/user-attachments/assets/949a5a5e-8eb5-49cd-b1b8-e68474455d07)

Checkout

![image](https://github.com/user-attachments/assets/b1dd0eb9-9e15-44e0-8cc0-85cd95cbf935)

Confirm Order

![image](https://github.com/user-attachments/assets/5327ea0e-831f-41a8-aed9-40cddab11846)

 Receipt

![image](https://github.com/user-attachments/assets/9878688e-4504-42da-b3e2-557d22a4c1e4)

 Screenshot of diagram
 
![image](https://github.com/user-attachments/assets/df64e1dc-5430-4be7-bc9e-37a53def3c21)


 ## Interesting Code: 

One interesting part of this project is  how the handleNewOrder() method acts as the central controller, managing user input
and dynamically building each part of the order—from sandwiches to drinks and chips—while also offering real-time feedback,
flexibility to cancel or confirm, and even generating a receipt file with the final order summary.





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
    
