package co.develhope.esercizioCustomQueries1.repo;

import co.develhope.esercizioCustomQueries1.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {

}
