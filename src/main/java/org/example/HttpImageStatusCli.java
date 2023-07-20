package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    private static Logger logger = LogManager.getLogger(HttpImageStatusCli.class);
    public void askStatus() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(("Enter HTTP status code"));
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        int code = 0;

        try {
            code = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            logger.error("Please enter valid number");
            askStatus();
        }finally {
            scanner.close();
        }
            new HttpStatusImageDownloader().downloadStatusImage(code);
    }
}
