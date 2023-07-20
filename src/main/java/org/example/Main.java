package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println(new HttpStatusChecker().getStatusImage(288));
//        new HttpStatusImageDownloader().downloadStatusImage(388);
        new HttpImageStatusCli().askStatus();
    }
}