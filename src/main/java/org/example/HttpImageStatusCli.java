package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
    int code;
    void askStatus() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter HTTP status code:");
            String status = scanner.nextLine();

            System.out.println("You Enter code " + status);
            code = Integer.parseInt(status);
            HttpStatusImageDownloader.downloadStatusImage(code);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Please enter valid number");
        } catch (Exception e) {
            System.out.println("Error downloading image");
        }
    }
}
