package co.develhope.esercizio.swagger.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class NameController {

    @Operation(
            summary = "Per ritornare il nome inserito",
            description = "Una volta inserito un qualsiasi nome, questo verra restituito")
    @GetMapping(value = "/name", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getName(@Parameter(description = "Nome che si vuole ritornare") @RequestParam String name) {
        return name;
    }

    @Operation(
            summary = "Per invertire il nome inserito",
            description = "Una volta inserito un nome lo si riceve al contrario grazie al metodo StringBuilder")
    @PostMapping(value = "/reverseName", produces = MediaType.TEXT_PLAIN_VALUE)
    public String reverseName(@Parameter(description = "Nome da invertire") @RequestParam String name) {
        return new StringBuilder(name).reverse().toString();
    }

}
