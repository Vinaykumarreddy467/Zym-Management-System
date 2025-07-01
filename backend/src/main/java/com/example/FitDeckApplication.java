package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitDeckApplication {

    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger(FitDeckApplication.class);
        SpringApplication.run(FitDeckApplication.class, args);
        
        System.out.println("FitDeck Application Started Successfully!");
        logger.info("FitDeck Application Started Successfully!");
    }
}