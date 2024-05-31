package co.develhope.esercizioCustomQueries1.controllers;

import co.develhope.esercizioCustomQueries1.entities.Flight;
import co.develhope.esercizioCustomQueries1.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepo flightRepo;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }

    @GetMapping("/provision")
    public List<Flight> provisionFlights() {
        Random random = new Random();
        List<Flight> flights = IntStream.range(0, 50)
                .mapToObj(i -> {
                    Flight flight = new Flight();
                    flight.setDescription("Flight " + i);
                    flight.setFromAirport("Airport " + random.nextInt(10));
                    flight.setToAirport("Airport " + random.nextInt(10));
                    flight.setStatus(Flight.Status.ON_TIME);
                    return flight;
                })
                .collect(Collectors.toList());

        return flightRepo.saveAll(flights);
    }

}
