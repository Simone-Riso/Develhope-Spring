package co.develhope.esercizioDeploy02.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@Profile("prod")
@RestController
public class ProdController {

    @GetMapping("/sum")
    public int getSum() {
        return generateRandomNumber() + generateRandomNumber();
    }

    private int generateRandomNumber() {
        return new Random().nextInt(100);
    }
}
