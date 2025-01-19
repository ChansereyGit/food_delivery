package com.food_delivery.service.handler;

import com.food_delivery.constant.Constant;
import com.food_delivery.dto.PaymentRequest;
import com.food_delivery.enumuration.PaymentMethod;
import com.food_delivery.enumuration.PaymentStatus;
import com.food_delivery.model.Payment;
import com.food_delivery.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
@Slf4j
public class PaymentHandlerService {
    private final PaymentRepository paymentRepository;
    private final KhQRHandlerService khQRHandlerService;
    private final CashHandlerService cashHandlerService;

    public PaymentHandlerService(PaymentRepository paymentRepository, KhQRHandlerService khQRHandlerService, CashHandlerService cashHandlerService) {
        this.paymentRepository = paymentRepository;
        this.khQRHandlerService = khQRHandlerService;
        this.cashHandlerService = cashHandlerService;
    }

    public String postingToPaymentGateway(PaymentRequest paymentRequest){
        log.info("Posting to payment gateway");
        if(Constant.BANK.equalsIgnoreCase(paymentRequest.getPaymentMethod())){
            log.info("Payment method is BANK");
            String khQRServerResponse = khQRHandlerService.postingToKhQRApi(paymentRequest);
            savePaymentTransaction(paymentRequest, khQRServerResponse);
            //verify that the response make sure it success or failed
            if(StringUtils.hasText(khQRServerResponse)){
                return Constant.SUCCESS;
            }
            return Constant.FAILED;
        }
        if (Constant.CASH.equalsIgnoreCase(paymentRequest.getPaymentMethod())) {
            log.info("Payment method is CASH");
            String cashServerResponse = cashHandlerService.postingToCASHApi(paymentRequest);
            savePaymentTransaction(paymentRequest, cashServerResponse);
            //verify that the response make sure it success or failed
            if(StringUtils.hasText(cashServerResponse)){
                return Constant.SUCCESS;
            }
            return Constant.FAILED;
        }
        if(Constant.CARD.equalsIgnoreCase(paymentRequest.getPaymentMethod())){
            log.info("Payment method is CARD");
            return Constant.SUCCESS;
        }
        log.info("Payment method is not supported");
        return Constant.FAILED;
    }

    public void savePaymentTransaction(PaymentRequest paymentRequest, String response){
        Payment payment = new Payment();
        payment.setPaymentMethod(PaymentMethod.valueOf(paymentRequest.getPaymentMethod()));

        if (StringUtils.hasText(response)){
            payment.setPaymentStatus(PaymentStatus.SUCCESS);
        }
        else {
            payment.setPaymentStatus(PaymentStatus.FAILED);
        }
        payment.setAmount(Double.valueOf(paymentRequest.getAmount()));
        payment.setOrderId(Long.valueOf(paymentRequest.getOrderId()));
        payment.setCreatedAt(new Date());
        payment.setCreatedBy(Constant.SYSTEM);
        log.info("Payment transaction saved successfully");
        paymentRepository.save(payment);
    }
}
