package org.example;

public class Main {
    public static void main(String[] args) {
        BankAPI bankAPI = new PaypalAdapter(new PaypalPaymentGateway());

        bankAPI.transfer("user_1@gmail.com", "user_2@gmail.com", 100);
    }
}