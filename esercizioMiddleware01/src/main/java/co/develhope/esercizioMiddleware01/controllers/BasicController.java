package co.develhope.esercizioMiddleware01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BasicController {

    @GetMapping("/time")
    public String getCurrentTime() {
        return "Current Date/Time: " + java.time.LocalDateTime.now();
    }
}
