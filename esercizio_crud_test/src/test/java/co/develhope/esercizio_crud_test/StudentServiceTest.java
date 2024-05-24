package co.develhope.esercizio_crud_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import co.develhope.esercizio_crud_test.entities.Student;
import co.develhope.esercizio_crud_test.repo.StudentRepository;
import co.develhope.esercizio_crud_test.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Test
    public void testCreateStudent() {
        Student student = new Student(1L,"Simone", "Riso", true);
        Student createdStudent = studentService.createStudent(student);

        assertEquals(student.getId(), createdStudent.getId());
        assertEquals(student.getName(), createdStudent.getName());
        assertEquals(student.getLastName(), createdStudent.getLastName());
        assertEquals(student.isWorking(), createdStudent.isWorking());
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student(1L,"Simon", "Rice", true);
        Student createdStudent = studentService.createStudent(student);

        Student updatedStudent = new Student(createdStudent.getId(), "Nomis", "Ecir", false);
        Student result = studentService.updateStudent(updatedStudent.getId(), updatedStudent);

        assertEquals(updatedStudent.getId(), result.getId());
        assertEquals(updatedStudent.getName(), result.getName());
        assertEquals(updatedStudent.getLastName(), result.getLastName());
        assertEquals(updatedStudent.isWorking(), result.isWorking());
    }

    @Test
    public void testGetAllStudents() {
        Student testStudent = new Student(1L, "Simone", "Riso", true);
        studentRepository.save(testStudent);

        List<Student> students = studentService.getAllStudents();

        assertTrue(!students.isEmpty(), "La lista degli studenti non dovrebbe essere vuota");
    }


    @Test
    public void testDeleteStudent() {
        Student student = new Student(1L,"Simone", "Riso", true);
        Student createdStudent = studentService.createStudent(student);
        studentService.deleteStudent(createdStudent.getId());

        List<Student> remainingStudents = studentService.getAllStudents();
        assertFalse(remainingStudents.contains(student));
    }

}
