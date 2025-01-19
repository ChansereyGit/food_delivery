package com.food_delivery.service.handler;

import com.food_delivery.dto.PaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class KhQRHandlerService {
    private final RestTemplate restTemplate;

    public KhQRHandlerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String  postingToKhQRApi(PaymentRequest paymentRequest){
        try{
            final String url = "https://demo_khqr.com/transactions/";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + "my-secret-token");

            HttpEntity<PaymentRequest> httpEntity = new HttpEntity<>(paymentRequest, headers);

            log.info("Posting to KHQR API: {}", paymentRequest);
            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    httpEntity,
                    String.class
            );
            log.info("Response from KHQR API: {}", response.getBody());

            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                return null;
            }
        }catch (Exception e){
            log.error("KhQR service response error: {}", e.getMessage());
        }
        return null;
    }
}
