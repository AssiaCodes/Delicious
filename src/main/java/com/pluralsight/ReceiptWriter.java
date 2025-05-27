package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptWriter {

    public static void createReceiptFile(String orderDetails) throws IOException {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String formattedDate = formatter.format(now);
        FileWriter fileWriter = new FileWriter("c://receipts//"+formattedDate+".txt");
        fileWriter.write(orderDetails);
        fileWriter.close();
    }
}
