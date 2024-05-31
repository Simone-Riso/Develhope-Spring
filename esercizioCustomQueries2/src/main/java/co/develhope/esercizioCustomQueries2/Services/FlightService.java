package co.develhope.esercizioCustomQueries2.Services;

import co.develhope.esercizioCustomQueries2.entities.Flight;
import co.develhope.esercizioCustomQueries2.repo.FlightRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final Random random = new Random();

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void provisionFlights(int n) {
        for (int i = 0; i < n; i++) {
            String fromAirport = generateRandomString();
            String toAirport = generateRandomString();
            String status = generateRandomStatus();
            Flight flight = new Flight(fromAirport, toAirport, status);
            flightRepository.save(flight);
        }
    }

    public Page<Flight> getAllFlights(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("fromAirport").ascending());
        return flightRepository.findAll(pageable);
    }

    public List<Flight> getOnTimeFlights() {
        return flightRepository.findByStatus("ONTIME");
    }

    public List<Flight> getCustomFlights(String status1, String status2) {
        return flightRepository.findByStatusIn(List.of(status1, status2));
    }

    private String generateRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private String generateRandomStatus() {
        String[] statuses = {"ONTIME", "DELAYED", "CANCELLED"};
        return statuses[random.nextInt(statuses.length)];
    }

}
