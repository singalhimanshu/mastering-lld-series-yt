package org.example;

public class PaypalAdapter implements BankAPI {
    private final PaypalPaymentGateway paypalPaymentGateway;

    public PaypalAdapter(PaypalPaymentGateway paypalPaymentGateway) {
        this.paypalPaymentGateway = paypalPaymentGateway;
    }

    @Override
    public void transfer(String from, String to, double amount) {
        paypalPaymentGateway.sendMoney(from, to, amount);
    }
}
