package com.gabriel.paymentservice.service;

import com.gabriel.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
