package com.bridgelabz.bookstoreapp.configuration;

import com.bridgelabz.bookstoreapp.utilities.MailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@Configuration
public class UserConfig {
    @Bean
    public MailService emailSenderService()
    {
        return new MailService();
    }
}
