package co.develhope.esercizio_crud_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import co.develhope.esercizio_crud_test.entities.Student;
import co.develhope.esercizio_crud_test.repo.StudentRepository;
import co.develhope.esercizio_crud_test.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testCreateStudent() {
        Student student = new Student();
        student.setName("Simon");
        student.setWorking(true);

        Student createdStudent = studentService.createStudent(student);

        assertEquals(student, createdStudent);
    }

    @Test
    public void testGetAllStudents() {
        Student student1 = new Student();
        student1.setName("Emiliano");
        student1.setWorking(true);
        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setName("Gianna");
        student2.setWorking(false);
        studentRepository.save(student2);

        List<Student> allStudents = studentService.getAllStudents();

        assertEquals(2, allStudents.size());

        assertEquals("Emiliano", allStudents.get(0).getName());
        assertEquals("Gianna", allStudents.get(1).getName());
    }

}
