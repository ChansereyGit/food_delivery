package com.food_delivery.service.impl;

import com.food_delivery.dto.PaymentRequest;
import com.food_delivery.service.PaymentService;
import com.food_delivery.service.handler.PaymentHandlerService;

public class PaymentServiceImpl implements PaymentService {

    private final PaymentHandlerService paymentHandlerService;

    public PaymentServiceImpl(PaymentHandlerService paymentHandlerService) {
        this.paymentHandlerService = paymentHandlerService;
    }

    @Override
    public String pay(PaymentRequest paymentRequest) {
        return paymentHandlerService.postingToPaymentGateway(paymentRequest);
    }

    @Override
    public String inquiry(String orderId) {
        return "";
    }
}
