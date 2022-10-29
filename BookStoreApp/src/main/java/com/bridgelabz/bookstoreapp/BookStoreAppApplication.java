package com.bridgelabz.bookstoreapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@Slf4j
@SpringBootApplication
public class BookStoreAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BookStoreAppApplication.class, args);
        log.info("Welcome to Book Store Application");
        log.info("Data Base Using :"+context.getEnvironment().getProperty("database"));
    }
}
