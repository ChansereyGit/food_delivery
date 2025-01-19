package com.food_delivery.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentRequest {

    @JsonProperty("amount")
    private String amount;

    @JsonProperty(" payment_method")
    private String paymentMethod;

    @JsonProperty("order_id")
    private String orderId;
}
