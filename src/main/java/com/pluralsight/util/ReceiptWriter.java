package com.pluralsight.util;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptWriter {
    // Creates a receipt file with the provided order details
    public static void createReceiptFile(String orderDetails) throws IOException {

        Date now = new Date();
        // Format the date/time as yyyyMMdd-HHmmss for the file name

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String formattedDate = formatter.format(now);

        // Create a new file writer for the receipt in the specified folder
        FileWriter fileWriter = new FileWriter("c://receipts//"+formattedDate+".txt");

        // Write the order details into the receipt file
        fileWriter.write(orderDetails);

        // Close the file writer to save the file properly
        fileWriter.close();
    }
}
