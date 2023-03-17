package com.collab.buddy.CollabBuddy.teacher;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@SpringBootTest
@AutoConfigureMockMvc
public class TeacherControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private TeacherRepository teacherRepository;

  @Test
  public void shouldReturnAllTeachers() throws Exception {
    // Given
    Teacher teacher1 = new Teacher(null, "John", 30, "john@gmail.com", "Math", ERole.TEACHER);
    Teacher teacher2 = new Teacher(null, "Jane", 35, "jane@gmail.com", "Science", ERole.TEACHER);
    teacherRepository.saveAll(Collections.singletonList(teacher1));
    teacherRepository.saveAll(Collections.singletonList(teacher2));

    // When and Then
    mockMvc.perform(MockMvcRequestBuilders.get("/teachers"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value(teacher1.getName()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[0].age").value(teacher1.getAge()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[0].email").value(teacher1.getEmail()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[0].specialty").value(teacher1.getSpecialty()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[0].role").value(teacher1.getRole().toString()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[1].name").value(teacher2.getName()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[1].age").value(teacher2.getAge()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[1].email").value(teacher2.getEmail()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[1].specialty").value(teacher2.getSpecialty()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[1].role").value(teacher2.getRole().toString()))
            .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void shouldReturnTeacherById() throws Exception {
    // Given
    Teacher teacher = new Teacher(null, "John", 30, "john@gmail.com", "Math", ERole.TEACHER);
    Teacher savedTeacher = teacherRepository.save(teacher);

    // When and Then
    mockMvc.perform(MockMvcRequestBuilders.get("/teachers/" + savedTeacher.getTeacherId()))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(savedTeacher.getName()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(savedTeacher.getAge()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(savedTeacher.getEmail()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.specialty").value(savedTeacher.getSpecialty()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.role").value(savedTeacher.getRole().toString()))
            .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void shouldCreateTeacher() throws Exception {
    // Given
    Teacher teacher = new Teacher();
    teacher.setName("John Smith");
    teacher.setAge(35);
    teacher.setEmail("john.smith@example.com");
    teacher.setSpecialty("Mathematics");

    String requestBody = new ObjectMapper().writeValueAsString(teacher);

    // When
    mockMvc.perform(post("/teachers")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestBody))

            // Then
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(teacher.getName())))
            .andExpect(jsonPath("$.age", is(teacher.getAge())))
            .andExpect(jsonPath("$.email", is(teacher.getEmail())))
            .andExpect(jsonPath("$.specialty", is(teacher.getSpecialty())));
  }
}