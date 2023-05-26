package com.example.camermarket.util;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {
    @Value("abcdefghijklmnopqrstuvwxyz")
    String plainSecretKey;
    @Value("300000")
     String expireLength;


}
