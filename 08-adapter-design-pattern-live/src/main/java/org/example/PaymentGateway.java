package org.example;

public interface PaymentGateway {
    void makePayment(String from, String to, double amount);
}
