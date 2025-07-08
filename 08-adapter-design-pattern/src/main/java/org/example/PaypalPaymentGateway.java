package org.example;

public class PaypalPaymentGateway {
    public void sendMoney(String sender, String receiver, double money) {
        System.out.println("Paypal: Sending $" + money + " from: " + sender + " to: " + receiver);
    }
}
