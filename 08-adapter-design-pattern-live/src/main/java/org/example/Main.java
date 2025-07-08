package org.example;

public class Main {
    public static void main(String[] args) {
        final PaymentGateway paymentGateway = new PaypalAdapter(new PaypalPaymentGateway());
        paymentGateway.makePayment("user1", "user2", 100);
        paymentGateway.makePayment("user2", "user1", 50);
    }
}