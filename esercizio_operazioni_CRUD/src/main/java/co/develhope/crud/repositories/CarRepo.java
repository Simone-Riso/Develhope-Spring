package co.develhope.crud.repositories;

import co.develhope.crud.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface CarRepo extends JpaRepository<Car, Long> {

}
