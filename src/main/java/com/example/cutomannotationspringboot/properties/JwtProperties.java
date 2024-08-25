package com.example.cutomannotationspringboot.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class JwtProperties {
    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expire}")
    private long expiration;
}
