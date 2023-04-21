package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        //Create database table and flat file with friend's birthdays
        ProcessBuilder processBuilder = new ProcessBuilder("load_data.sh");
        try {
            processBuilder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}