package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class HttpStatusImageDownloader {
    static void downloadStatusImage(int code) {
        String imageUrl = HttpStatusChecker.getStatusImage(code);
        String outputFileName = "downloadImage" + code + ".jpg";

        try {
            Connection connection = Jsoup.connect(imageUrl).ignoreContentType(true);
            Connection.Response response = connection.execute();
            if (response.statusCode() == 200) {
                InputStream inputStream = response.bodyStream();
                OutputStream outputStream = new FileOutputStream(outputFileName);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.close();
                inputStream.close();
                System.out.println("Image downloaded and saved as " + outputFileName);
            } else {
                System.out.println("Error downloading image. Response code: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error downloading image");
        }
    }
}
