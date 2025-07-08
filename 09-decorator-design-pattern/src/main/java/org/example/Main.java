package org.example;

public class Main {
    public static void main(String[] args) {
        final Logger logger = new ConsoleLogger();
        new EncryptLogger(new TimestampLogger(logger))
                .log("decorator design pattern video");
    }
}
