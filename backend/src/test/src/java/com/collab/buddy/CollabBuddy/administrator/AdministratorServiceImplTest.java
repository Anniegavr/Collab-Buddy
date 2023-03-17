package com.collab.buddy.CollabBuddy.administrator;

import com.collab.buddy.CollabBuddy.administrator.Administrator;
import com.collab.buddy.CollabBuddy.administrator.AdministratorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdministratorServiceImplTest {
  @Mock
  private AdministratorRepository administratorRepository;

  @InjectMocks
  private AdministratorServiceImpl administratorService;

  private Administrator administrator;

  @BeforeEach
  void setUp() {
    administrator = new Administrator();
    administrator.setAdminId(1L);
    administrator.setName("John Doe");
    administrator.setAge(30);
    administrator.setEmail("john.doe@example.com");
    administrator.setCourse("IT");
  }

  @Test
  void testCreateAdministrator() {
    // arrange and act
    when(administratorRepository.save(any(Administrator.class))).thenReturn(administrator);

    Administrator createdAdministrator = administratorService.createAdministrator(administrator);
    // assert
    assertNotNull(createdAdministrator);
    assertEquals(administrator.getName(), createdAdministrator.getName());
    assertEquals(administrator.getAge(), createdAdministrator.getAge());
    assertEquals(administrator.getEmail(), createdAdministrator.getEmail());
    assertEquals(administrator.getCourse(), createdAdministrator.getCourse());

    verify(administratorRepository, times(1)).save(any(Administrator.class));
  }

  @Test
  void testUpdateAdministrator() {
    // arrange
    int newAge = 35;
    
    // act
    when(administratorRepository.findById(administrator.getAdminId())).thenReturn(java.util.Optional.ofNullable(administrator));
    when(administratorRepository.updateAgeBy(anyInt())).thenReturn(administrator);

    Administrator updatedAdministrator = administratorService.updateAdministrator(administrator.getAdminId(), newAge);
    // assert
    assertNotNull(updatedAdministrator);
    assertEquals(administrator.getName(), updatedAdministrator.getName());
    assertEquals(newAge, updatedAdministrator.getAge());
    assertEquals(administrator.getEmail(), updatedAdministrator.getEmail());
    assertEquals(administrator.getCourse(), updatedAdministrator.getCourse());

    verify(administratorRepository, times(1)).findById(administrator.getAdminId());
    verify(administratorRepository, times(1)).updateAgeBy(anyInt());
  }
}
