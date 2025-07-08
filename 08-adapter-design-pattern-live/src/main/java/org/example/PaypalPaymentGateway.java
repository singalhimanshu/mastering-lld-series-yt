package org.example;

public class PaypalPaymentGateway {
    public void sendMoney(String to, String from, double amount) {
        System.out.println("[paypal payment gateway] sending: " + amount + " to: " + to + " from: " + from);
    }
}
