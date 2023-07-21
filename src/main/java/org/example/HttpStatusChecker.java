package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code)  {


            String imageUrl = "https://http.cat/" + code + ".jpg";
            try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == 404) {
                throw new RuntimeException("картинки немає");
            }
        } catch (IOException e) {
            try {
                throw new Exception("Error while checking for image availability: " + e.getMessage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        return imageUrl;
    }
}
