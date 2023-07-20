package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class HttpStatusImageDownloader {
    private static Logger logger = LogManager.getLogger(HttpStatusImageDownloader.class);
    public void downloadStatusImage(int code) throws IOException {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String url = httpStatusChecker.getStatusImage(code);
        InputStream inputStream;
        inputStream = new URL(url).openStream();
        Files.copy(inputStream, Paths.get("/Users/mac/IdeaProjects/RestHomework/src/main/resources/images/" + "image" + code + ".jpg"), StandardCopyOption.REPLACE_EXISTING);
        inputStream.close();



    }
}
