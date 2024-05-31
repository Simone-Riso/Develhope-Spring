package co.develhope.esercizioCustomQueries2.controllers;

import co.develhope.esercizioCustomQueries2.Services.FlightService;
import co.develhope.esercizioCustomQueries2.entities.Flight;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights")
    public ResponseEntity<Void> provisionFlights(@RequestParam(required = false, defaultValue = "100") int n) {
        flightService.provisionFlights(n);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/flights/all")
    public ResponseEntity<Page<Flight>> getAllFlights(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        Page<Flight> flights = flightService.getAllFlights(page, size);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/flights/ontime")
    public ResponseEntity<List<Flight>> getOnTimeFlights() {
        List<Flight> flights = flightService.getOnTimeFlights();
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/flights/custom/{status1}/{status2}")
    public ResponseEntity<List<Flight>> getCustomFlights(@PathVariable String status1, @PathVariable String status2) {
        List<Flight> flights = flightService.getCustomFlights(status1, status2);
        return ResponseEntity.ok(flights);
    }

}
