package com.microservices.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.time.ZoneId;
import java.util.TimeZone;

/**
 * Entry point for the Config Server application.
 * 
 * This service centralizes configuration management
 * for all microservices in the ecosystem.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {

        // Set default timezone (good practice in distributed systems)
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("UTC")));

        SpringApplication app = new SpringApplication(ConfigServerApplication.class);
        app.setLogStartupInfo(true);  // Ensures startup logs are printed clearly
        app.run(args);
    }
}
