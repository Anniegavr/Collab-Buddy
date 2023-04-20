package com.collab.buddy.teacher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherServiceImplTest {

  @Mock
  private TeacherRepository teacherRepository;

  @InjectMocks
  private TeacherServiceImpl teacherService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Test shouldReturnAllTeachers()")
  void shouldReturnAllTeachers() {
    // Arrange
    List<Teacher> teachers = new ArrayList<>();
    Teacher teacher = new Teacher();
    teacher.setFirstName("John");
    teacher.setLastName("Doe");
    teacher.setId(1L);
    teacher.setEmail("johndoe@example.com");
    teacher.setAge(35);

    Teacher teacher1 = new Teacher();
    teacher1.setFirstName("John");
    teacher1.setLastName("Doe");
    teacher1.setId(2L);
    teacher1.setEmail("janesmith@example.com");
    teacher1.setAge(40);

    when(teacherRepository.findAll()).thenReturn(teachers);

    // Act
    List<TeacherDTO> result = teacherService.getAllTeachers();

    // Assert
    assertEquals(2, result.size());
    assertEquals("John Doe", result.get(0).getFirstName()+result.get(0).getLastName());
    assertEquals("janesmith@example.com", result.get(1).getEmail());
    assertEquals(40, result.get(1).getAge());
  }

  @Test
  @DisplayName("Test shouldReturnTeacherById()")
  void shouldReturnTeacherById() {
    // Arrange
    Teacher teacher = new Teacher();//1L, "John Doe", 35, "johndoe@example.com", "Mathematics");

    // Act
    TeacherDTO result = teacherService.getTeacherByTeacherId(1L);

    // Assert
    assertEquals("John Doe", result.getFirstName()+result.getLastName());
    assertEquals("johndoe@example.com", result.getEmail());
    assertEquals(35, result.getAge());
  }
}
