package co.develhope.esercizo.cors.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class NameController {

    @GetMapping("/name")
    public String getName(@RequestParam String name) {
        return name;
    }

    @PostMapping("/reverseName")
    public String reverseName(@RequestParam String name) {
        return new StringBuilder(name).reverse().toString();
    }

}
