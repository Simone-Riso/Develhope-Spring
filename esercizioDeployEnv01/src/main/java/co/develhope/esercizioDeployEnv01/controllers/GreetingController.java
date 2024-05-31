package co.develhope.esercizioDeployEnv01.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${authCode}")
    private String authCode;

    @Value("${devName}")
    private String devName;

    @GetMapping("/")
    public String greeting() {
        return "Hello, " + devName + "! Your auth code is: " + authCode;
    }

}
