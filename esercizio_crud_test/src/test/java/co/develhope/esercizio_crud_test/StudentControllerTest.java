package co.develhope.esercizio_crud_test;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import co.develhope.esercizio_crud_test.controllers.StudentController;
import co.develhope.esercizio_crud_test.entities.Student;
import co.develhope.esercizio_crud_test.service.StudentService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Collections;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    @Order(1)
    public void testCreateStudent() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("Simone");
        student.setLastName("Riso");
        student.setWorking(true);

        when(studentService.createStudent(any(Student.class))).thenReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"id\": 1, \"firstName\": \"Simone\", \"lastName\": \"Riso\", \"working\": true }")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Simone"))
                .andExpect(jsonPath("$.lastName").value("Riso"))
                .andExpect(jsonPath("$.working").value(true));
    }


    @Test
    @Order(2)
    public void testGetAllStudents() throws Exception {
        when(studentService.getAllStudents()).thenReturn(Collections.singletonList(new Student(
                1L,
                "Simone",
                "Riso",
                true)));

        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].name").value("Simone"))
                .andExpect(jsonPath("$[0].lastName").value("Riso"))
                .andExpect(jsonPath("$[0].working").value(true));
    }

    @Test
    @Order(3)
    public void testGetStudentById() throws Exception {
        Student student = new Student(
                1L,
                "Simone",
                "Riso",
                true);
        when(studentService.getStudentById(1L)).thenReturn(Optional.of(student));

        mockMvc.perform(MockMvcRequestBuilders.get("/students/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Simone"))
                .andExpect(jsonPath("$.lastName").value("Riso"))
                .andExpect(jsonPath("$.working").value(true));
    }

    @Test
    @Order(4)
    public void testUpdateStudent() throws Exception {
        Student updatedStudent = new Student(
                1L,
                "Simon",
                "Rice",
                true);
        when(studentService.updateStudent(eq(1L), any(Student.class))).thenReturn(updatedStudent);

        mockMvc.perform(MockMvcRequestBuilders.put("/students/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"Simon\",\"lastName\":\"Rice\",\"working\":true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Simon"))
                .andExpect(jsonPath("$.lastName").value("Rice"))
                .andExpect(jsonPath("$.working").value(true));
    }

    @Test
    @Order(5)
    public void testUpdateIsWorking() throws Exception {
        doNothing().when(studentService).updateIsWorking(eq(1L), anyBoolean());

        mockMvc.perform(MockMvcRequestBuilders.patch("/students/1?working=true"))
                .andExpect(status().isOk());

        verify(studentService, times(1)).updateIsWorking(eq(1L), eq(true));
    }

    @Test
    @Order(6)
    public void testDeleteStudent() throws Exception {
        doNothing().when(studentService).deleteStudent(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/students/1"))
                .andExpect(status().isNoContent());

        verify(studentService, times(1)).deleteStudent(1L);
    }

}
