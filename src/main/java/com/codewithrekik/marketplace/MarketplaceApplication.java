package com.codewithrekik.marketplace;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
/**
 * This is the main entry point for the Marketplace application.
 *
 */
@SpringBootApplication
public class MarketplaceApplication {
    /**
     * The main method, which is the entry point for the application.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(MarketplaceApplication.class, args);
    }
    /**
     * This method creates a CommandLineRunner bean that is executed after the application context is loaded.
     * It can be used to seed initial data or perform other tasks on application startup.
     *
     * @return A CommandLineRunner bean
     */
    @Bean
    public CommandLineRunner seedData() {
        return args -> {

            System.out.println("Seeding initial data...");
        };
    }
}