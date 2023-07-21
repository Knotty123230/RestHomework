package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    private static final Logger logger = LogManager.getLogger(HttpImageStatusCli.class);
    public void askStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(("Enter HTTP status code"));
        int code = 0;

        try {
            code = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            logger.error("Please enter valid number");
            askStatus();
        }finally {
            scanner.close();
        }
        try {
            new HttpStatusImageDownloader().downloadStatusImage(code);
        }catch (Exception e){
            logger.error("There is not image for HTTP status {}", code);
        }

    }
}
