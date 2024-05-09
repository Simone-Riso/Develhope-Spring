package com.example.demowebapp;

import org.springframework.web.bind.annotation.*;

@RestController
public class appSaluto {

    @GetMapping(path = "/v1/ciao")
    public String ciao(@RequestParam(required = true) String nome,
                       @RequestParam(required = false, defaultValue = "") String provincia) {
        return "Ciao " + nome + ", com'è il tempo in " + provincia + " ?";
    }

}
