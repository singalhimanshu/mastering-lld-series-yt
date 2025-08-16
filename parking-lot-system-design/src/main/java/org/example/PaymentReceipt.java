package org.example;

import java.time.LocalDateTime;

public record PaymentReceipt(String id, Double amount, LocalDateTime timestamp, PaymentType paymentType) {
}
