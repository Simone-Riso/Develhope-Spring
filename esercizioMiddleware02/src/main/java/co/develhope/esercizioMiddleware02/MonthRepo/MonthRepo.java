package co.develhope.esercizioMiddleware02.MonthRepo;

import co.develhope.esercizioMiddleware02.entitites.Month;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthRepo extends JpaRepository<Month, Long> {

}
