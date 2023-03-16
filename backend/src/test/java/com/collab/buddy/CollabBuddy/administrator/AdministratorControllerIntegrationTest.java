package com.collab.buddy.CollabBuddy.administrator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AdministratorController.class)
public class AdministratorControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private AdministratorServiceImpl administratorService;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void getAllAdministrators_shouldReturnListOfAdministrators() throws Exception {
    // Arrange
    Administrator administrator1 = new Administrator("John", 30, "john@gmail.com", "IT");
    Administrator administrator2 = new Administrator("Jane", 35, "jane@gmail.com", "HR");
    List<Administrator> administrators = Arrays.asList(administrator1, administrator2);
    given(administratorService.getAllAdministrators()).willReturn(administrators);

    // Act and Assert
    mockMvc.perform(get("/admin"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].name", is("John")))
            .andExpect(jsonPath("$[1].name", is("Jane")));
  }

  @Test
  public void getAdministratorById_shouldReturnAdministrator() throws Exception {
    // Arrange
    Administrator administrator = new Administrator("John", 30, "john@gmail.com", "IT");
    given(administratorService.getAdministratorByAdministratorId(1L)).willReturn(administrator);

    // Act and Assert
    mockMvc.perform(get("/admin/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name", is("John")));
  }

  @Test
  public void createAdministratorTest() throws Exception {
    Administrator administrator = new Administrator();
    administrator.setName("Test Admin");
    administrator.setAge(30);
    administrator.setEmail("testadmin@example.com");
    administrator.setSpecialty("Test Specialty");

    String json = objectMapper.writeValueAsString(administrator);

    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/admin")
                                               .content(json)
                                               .contentType(MediaType.APPLICATION_JSON)
                                               .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();

    String responseContent = result.getResponse().getContentAsString();
    Administrator createdAdministrator = objectMapper.readValue(responseContent, Administrator.class);

    assertThat(createdAdministrator.getName()).isEqualTo(administrator.getName());
    assertThat(createdAdministrator.getAge()).isEqualTo(administrator.getAge());
    assertThat(createdAdministrator.getEmail()).isEqualTo(administrator.getEmail());
    assertThat(createdAdministrator.getSpecialty()).isEqualTo(administrator.getSpecialty());
  }
}
