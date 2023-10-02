package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class HttpStatusChecker {
    private static final String BASE_URL = "https://http.cat/status/";

    public static String getStatusImage(int code) {
        String urlStart = BASE_URL + code;
        String urlImg = " ";

        Connection connection = null;
        try {
            connection = Jsoup.connect(urlStart).ignoreContentType(true);
            Connection.Response response = connection.execute();

            if (response.statusCode() == 200) {
                urlImg = "https://http.cat/images/" + code + ".jpg";
            } else {
                System.out.println("There is no image for HTTP status: " + code);
            }
        } catch (Exception e) {
            System.out.println("Error connecting to the server");
        }
        return urlImg;
    }
}
