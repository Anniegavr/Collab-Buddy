package com.collab.buddy.CollabBuddy.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void testCreateStudent() throws Exception {
    // Create a new student
    Student student = new Student();
    student.setName("John Doe");
    student.setAge(25);
    student.setEmail("john.doe@example.com");

    // Convert the student object to JSON
    String studentJson = objectMapper.writeValueAsString(student);

    // Send a POST request to the /students endpoint with the student JSON as the request body
    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/students")
                                                          .contentType(MediaType.APPLICATION_JSON)
                                                          .content(studentJson));

    // Verify that the status code is 201 (Created)
    resultActions.andExpect(status().isCreated());

    // Verify that the response body contains the created student object as JSON
    resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value(student.getName()))
            .andExpect(jsonPath("$.age").value(student.getAge()))
            .andExpect(jsonPath("$.email").value(student.getEmail()));
  }
}
