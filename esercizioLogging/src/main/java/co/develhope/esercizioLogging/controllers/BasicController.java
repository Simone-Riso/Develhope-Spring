package co.develhope.esercizioLogging.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    private static final Logger logger = LoggerFactory.getLogger(BasicController.class);

    @Value("${custom.env.var1:2}")
    private int envVar1;

    @Value("${custom.env.var2:8}")
    private int envVar2;

    @GetMapping("/")
    public String welcome() {
        logger.info("\u001B[34mWelcome message logged with ANSI color enabled.");
        return "Welcome to my Spring Boot application!";
    }

    @GetMapping("/exp")
    public String calculatePower() {
        logger.debug("Starting calculation...");
        double result = Math.pow(envVar1, envVar2);
        logger.debug("Calculation completed. Result: {}", result);
        return "The power of " + envVar1 + " raised to " + envVar2 + " is: " + result;
    }

    @GetMapping("/get-errors")
    public String throwCustomError() {
        logger.error("An error occurred!");
        throw new RuntimeException("Custom error occurred!");
    }

}
