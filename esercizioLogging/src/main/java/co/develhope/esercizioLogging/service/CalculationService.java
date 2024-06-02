package co.develhope.esercizioLogging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    private static final Logger logger = LoggerFactory.getLogger(CalculationService.class);

    @Value("${custom.env.var1:2}")
    private int envVar1;

    @Value("${custom.env.var2:8}")
    private int envVar2;

    public double calculatePower() {
        logger.debug("Starting calculation...");
        double result = Math.pow(envVar1, envVar2);
        logger.debug("Calculation completed. Result: {}", result);
        return result;
    }

}
