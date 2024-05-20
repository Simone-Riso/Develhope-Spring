package co.develhope.crud.controllers;

import co.develhope.crud.entities.Car;
import co.develhope.crud.repositories.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CarController {

    @Autowired
    private CarRepo carRepo;

    @PostMapping("/createCar")
    public Car createCar(@RequestBody Car car) {
        Car carSaved = carRepo.saveAndFlush(car);
        return carSaved;
    }

    @GetMapping("/getAllCars")
    public List<Car> getAllCars() {
        List<Car> cars = carRepo.findAll();
        return cars;
    }

    @GetMapping("/getCar/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id) {
        if (carRepo.existsById(id)) {
            Car car = carRepo.findById(id).orElse(null);
            return ResponseEntity.ok(car); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 400 NOT FOUND
        }
    }

    @PutMapping("/updateCar/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable long id, @RequestBody Car car) {
        if (carRepo.existsById(id)) {
            car.setId(id);
            Car updatedCar = carRepo.saveAndFlush(car);
            return ResponseEntity.ok(updatedCar); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 400 NOT FOUND
        }
    }


    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable long id) {
        if (carRepo.existsById(id)) {
            carRepo.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 NO CONTENT
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409 CONFLICT
        }
    }

    @DeleteMapping("")
    public void deleteCars(@RequestParam List<Long> ids) {
        carRepo.deleteAllById(ids);
    }

}
