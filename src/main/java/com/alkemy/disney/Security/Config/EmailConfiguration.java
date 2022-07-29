package com.alkemy.disney.Security.Config;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfiguration {
    @Value("${com.alkemy.disney.email.sender.apiKey}")
    private String key;

    @Bean public SendGrid getSendgrid() {
        return new SendGrid(key);
    }
}

