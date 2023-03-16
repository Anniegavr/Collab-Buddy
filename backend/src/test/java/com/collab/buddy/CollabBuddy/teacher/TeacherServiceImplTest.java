package com.collab.buddy.CollabBuddy.teacher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherServiceImplTest {

  @Mock
  private TeacherRepository teacherRepository;

  @InjectMocks
  private TeacherServiceImpl teacherService;

  @Test
  public void shouldReturnAllTeachers() {
    // Given
    List<Teacher> teachers = new ArrayList<>();
    teachers.add(new Teacher(1L, "John Doe", 35, "johndoe@example.com", "Mathematics"));
    teachers.add(new Teacher(2L, "Jane Smith", 40, "janesmith@example.com", "Science"));
    when(teacherRepository.findAll()).thenReturn(teachers);

    // When
    List<Teacher> result = teacherService.getAllTeachers();

    // Then
    assertEquals(2, result.size());
    assertEquals("John Doe", result.get(0).getName());
    assertEquals("Mathematics", result.get(0).getSpecialty());
    assertEquals("janesmith@example.com", result.get(1).getEmail());
    assertEquals(40, result.get(1).getAge());
  }

  @Test
  public void shouldReturnTeacherById() {
    // Given
    Teacher teacher = new Teacher(1L, "John Doe", 35, "johndoe@example.com", "Mathematics");
    when(teacherRepository.findById(1L)).thenReturn(Optional.of(teacher));

    // When
    Teacher result = teacherService.getTeacherByTeacherId(1L);

    // Then
    assertEquals("John Doe", result.getName());
    assertEquals("johndoe@example.com", result.getEmail());
    assertEquals(35, result.getAge());
    assertEquals("Mathematics", result.getSpecialty());
  }

}
