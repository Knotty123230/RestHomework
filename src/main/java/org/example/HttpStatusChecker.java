package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    private static Logger logger = LogManager.getLogger(HttpStatusChecker.class);
    public String getStatusImage(int code) throws IOException {
        String imageUrl = "https://http.cat/" + code + ".jpg";
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == 404){
            throw new RuntimeException("There is not image for HTTP status " + code);
        }

        return imageUrl;
    }
}
