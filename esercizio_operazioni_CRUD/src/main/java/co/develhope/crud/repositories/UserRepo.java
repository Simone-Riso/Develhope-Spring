package co.develhope.crud.repositories;

import co.develhope.crud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface UserRepo extends JpaRepository<User, Long> {
}
