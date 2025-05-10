package com.yuliia.app.calendar.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {
    private Jwt jwt = new Jwt();

    @Data
    public static class Jwt {
        private String secret;
        private long expiration;
    }
}