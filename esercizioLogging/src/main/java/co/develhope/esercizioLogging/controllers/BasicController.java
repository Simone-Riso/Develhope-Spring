package co.develhope.esercizioLogging.controllers;

import co.develhope.esercizioLogging.service.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    private static final Logger logger = LoggerFactory.getLogger(BasicController.class);

    @Autowired
    private CalculationService calculationService;

    @GetMapping("/")
    public String welcome() {
        logger.info("Welcome message logged.");
        return "Welcome to my Spring Boot application!";
    }

    @GetMapping("/exp")
    public String calculatePower() {
        logger.debug("Starting calculation...");
        double result = calculationService.calculatePower();
        logger.debug("Calculation completed. Result: {}", result);
        return "The power is: " + result;
    }

    @GetMapping("/get-errors")
    public ResponseEntity<String> throwCustomError() {
        logger.error("An error occurred!");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Custom error occurred!");
    }

}
