package com.example.ControllerConGETCompleta;

import org.springframework.web.bind.annotation.*;

@RestController
public class appSaluto {

    @GetMapping(path = "/v2/ciao/Lombardia")
    public User ciao(
            @RequestParam(required = true) String nome,
            @RequestParam(required = false, defaultValue = "Lombardia") String provincia) {

        return new User(nome, provincia);
    }

}
