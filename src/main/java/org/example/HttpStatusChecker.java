package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.impl.Log4jContextFactory;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

public class HttpStatusChecker {
    private static Logger logger = LogManager.getLogger(HttpStatusChecker.class);
    public String getStatusImage(int code) throws IOException {
        String imageUrl = "https://http.cat/" + code + ".jpg";
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == 404) {
            logger.error("Картинку не знайдено! Код відповіді 404");
        }

        return imageUrl;
    }
}
