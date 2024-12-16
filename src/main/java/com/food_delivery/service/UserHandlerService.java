package com.food_delivery.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class UserHandlerService {

    public void userNameHasText(String userName){
        if(StringUtils.hasText(userName)){
            return;
        }
        log.info("User name empty");
        throw new IllegalArgumentException("User name must not be empty");
    }

    public void phoneNumberHasText(String phoneNumber ){
        if(StringUtils.hasText(phoneNumber)){
            return;
        }
        log.info("Phone number empty");
        throw new IllegalArgumentException("Phone number must not be empty");
    }
}
