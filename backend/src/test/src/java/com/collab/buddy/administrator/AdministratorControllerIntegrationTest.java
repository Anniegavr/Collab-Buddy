package com.collab.buddy.administrator;

import com.collab.buddy.config.role.ERole;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssumptions.given;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static reactor.netty.http.HttpResources.get;

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
    Administrator administrator1 = new Administrator();
    administrator1.setUsername("John");
    administrator1.setId(1L);
    administrator1.setAge(30);
    administrator1.setEmail("john@gmail.com");
    administrator1.setSpecialty("IT");
    Administrator administrator2 = new Administrator();
    administrator2.setId(2L);
    administrator2.setUsername("Jane");
    administrator2.setEmail("jane@gmail.com");
    administrator2.setSpecialty("HR");
    List<Administrator> administrators = Arrays.asList(administrator1, administrator2);
    given(administratorService.getAllAdministrators()).containsAll(administrators);

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
    AdministratorDTO administrator = new AdministratorDTO; //("John Doe", 30, "john@gmail.com", "IT");
    administrator.name = "John Doe";
    administrator.email = "john@gmail.com";
    administrator.specialty = "IT";
    administrator.eRole = ERole.ADMIN;
    given(administratorService.getAdministratorByAdministratorId(1L)).isEqualTo(administrator);

    // Act and Assert
    mockMvc.perform(get("/admin/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name", is("John")));
  }

  @Test
  public void createAdministratorTest() throws Exception {
    Administrator administrator = new Administrator();
    administrator.setUsername("Test Admin");
    administrator.setAge(30);
    administrator.setEmail("testadmin@example.com");
    administrator.setSpecialty("Test Course");

    String json = objectMapper.writeValueAsString(administrator);

    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/admin")
                                               .content(json)
                                               .contentType(MediaType.APPLICATION_JSON)
                                               .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();

    String responseContent = result.getResponse().getContentAsString();
    Administrator createdAdministrator = objectMapper.readValue(responseContent, Administrator.class);

    assertThat(createdAdministrator.getUsername()).isEqualTo(administrator.getUsername());
    assertThat(createdAdministrator.getAge()).isEqualTo(administrator.getAge());
    assertThat(createdAdministrator.getEmail()).isEqualTo(administrator.getEmail());
    assertThat(createdAdministrator.getSpecialty()).isEqualTo(administrator.getSpecialty());
  }
}
