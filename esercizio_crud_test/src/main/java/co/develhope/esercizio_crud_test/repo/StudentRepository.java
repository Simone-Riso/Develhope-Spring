package co.develhope.esercizio_crud_test.repo;

import co.develhope.esercizio_crud_test.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}

