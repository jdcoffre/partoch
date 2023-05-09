package org.jd.partoch.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PartochApplication {

    @Value("${partoch.db:partoch.db}")
    private String database;

    private Logger logger = LogManager.getLogger(PartochApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PartochApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        logger.info("-----------------------------------> %s", database);
        return String.format("Hello %s!", name);
    }

    @GetMapping("/")
    public String home() {
        logger.info("----------------------------------->  %s", database);
        return String.format("Hello %s!", "test");
    }
}