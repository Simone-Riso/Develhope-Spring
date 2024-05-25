package co.develhope.esercizio_test_unit.repository;

import co.develhope.esercizio_test_unit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
