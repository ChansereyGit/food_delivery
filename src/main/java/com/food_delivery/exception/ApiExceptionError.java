package com.food_delivery.exception;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiExceptionError {

    private String errorCode;
    private String message;
    private Object responseData;
    private String statusCode;
}
