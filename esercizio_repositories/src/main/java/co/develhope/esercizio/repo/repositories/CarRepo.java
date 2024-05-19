package co.develhope.esercizio.repo.repositories;

import co.develhope.esercizio.repo.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepo extends JpaRepository<Car, Long> {

}
