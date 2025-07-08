package org.example;

public class PaypalAdapter implements PaymentGateway {
    private final PaypalPaymentGateway paypalPaymentGateway;

    public PaypalAdapter(PaypalPaymentGateway paypalPaymentGateway) {
        this.paypalPaymentGateway = paypalPaymentGateway;
    }

    @Override
    public void makePayment(String from, String to, double amount) {
        System.out.println("made payment from: " + from + " to: " + to + " amount:" + amount);
        paypalPaymentGateway.sendMoney(to, from, amount);
    }
}
