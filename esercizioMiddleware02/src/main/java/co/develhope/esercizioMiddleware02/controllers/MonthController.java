package co.develhope.esercizioMiddleware02.controllers;

import co.develhope.esercizioMiddleware02.MonthRepo.MonthRepo;
import co.develhope.esercizioMiddleware02.entitites.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/months")
public class MonthController {

    @Autowired
    private MonthRepo monthRepo;

    @GetMapping
    public List<Month> getAllMonths() {
        return monthRepo.findAll();
    }

    @GetMapping("/{id}")
    public Month getMonthById(@PathVariable Long id) {
        return monthRepo.findById(id).orElseThrow(() -> new RuntimeException("Month not found with id: " + id));
    }

}
