package com.collab.buddy.administrator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    administrator.setId(1L);
    administrator.setFirstName("John");
    administrator.setLastName("Doe");
    administrator.setAge(30);
    administrator.setEmail("john.doe@example.com");
    administrator.setSpecialty("IT");
  }

  @Test
  void testCreateAdministrator() {
    // arrange and act
    when(administratorRepository.save(any(Administrator.class))).thenReturn(administrator);

    AdministratorDTO createdAdministrator = administratorService.createAdministrator(administrator);
    // assert
    assertNotNull(createdAdministrator);
    assertEquals(administrator.getEmail(), createdAdministrator.email);
    assertEquals(administrator.getSpecialty(), createdAdministrator.specialty);

    verify(administratorRepository, times(1)).save(any(Administrator.class));
  }

//  @Test
//  void testUpdateAdministrator() {
//    // arrange
//    int newAge = 35;
//
//    // act
//    when(administratorRepository.findById(administrator.getId())).thenReturn(java.util.Optional.ofNullable(administrator));
//    when(administratorRepository.updateAgeBy(anyInt())).thenReturn(administrator);
//
//    AdministratorDTO updatedAdministrator = administratorService.updateAdministrator(administrator.getId(), newAge);
//    // assert
//    assertNotNull(updatedAdministrator);
//    assertEquals(getAdminName(administrator), updatedAdministrator.name);
//    assertEquals(administrator.getEmail(), updatedAdministrator.email);
//    assertEquals(administrator.getSpecialty(), updatedAdministrator.specialty);
//
//    verify(administratorRepository, times(1)).findById(administrator.getId());
//    verify(administratorRepository, times(1)).updateAgeBy(anyInt());
//  }

}
