package com.collab.buddy.CollabBuddy.teacher;

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
public class TeacherServiceImplTest {

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
  public void shouldReturnAllTeachers() {
    // Arrange
    List<Teacher> teachers = new ArrayList<>();
    teachers.add(new Teacher(1L, "John Doe", 35, "johndoe@example.com", "Mathematics"));
    teachers.add(new Teacher(2L, "Jane Smith", 40, "janesmith@example.com", "Science"));
    when(teacherRepository.findAll()).thenReturn(teachers);

    // Act
    List<Teacher> result = teacherService.getAllTeachers();

    // Assert
    assertEquals(2, result.size());
    assertEquals("John Doe", result.get(0).getName());
    assertEquals("Mathematics", result.get(0).getSpecialty());
    assertEquals("janesmith@example.com", result.get(1).getEmail());
    assertEquals(40, result.get(1).getAge());
  }

  @Test
  @DisplayName("Test shouldReturnTeacherById()")
  public void shouldReturnTeacherById() {
    // Arrange
    Teacher teacher = new Teacher(1L, "John Doe", 35, "johndoe@example.com", "Mathematics");
    when(teacherRepository.findById(1L)).thenReturn(Optional.of(teacher));

    // Act
    Teacher result = teacherService.getTeacherByTeacherId(1L);

    // Assert
    assertEquals("John Doe", result.getName());
    assertEquals("johndoe@example.com", result.getEmail());
    assertEquals(35, result.getAge());
    assertEquals("Mathematics", result.getSpecialty());
  }

}
