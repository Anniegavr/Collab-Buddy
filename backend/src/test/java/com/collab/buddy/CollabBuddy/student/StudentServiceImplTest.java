package com.collab.buddy.CollabBuddy.student;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

  @Mock
  private StudentRepository studentRepository;

  @InjectMocks
  private StudentServiceImpl studentService;

  @Test
  public void updateStudent_ShouldReturnUpdatedStudent() throws Exception {
    // Arrange
    Long id = 1L;
    Student existingStudent = new Student();
    existingStudent.setStudentId(id);
    existingStudent.setName("John Doe");
    existingStudent.setAge(25);
    existingStudent.setEmail("john.doe@example.com");

    Student updatedStudent = new Student();
    updatedStudent.setName("Jane Doe");
    updatedStudent.setAge(27);
    updatedStudent.setEmail("jane.doe@example.com");

    when(studentRepository.findStudentByStudentId(id)).thenReturn(Optional.of(existingStudent));
    when(studentRepository.save(existingStudent)).thenReturn(existingStudent);

    // Act
    Student result = studentService.updateStudent(id, updatedStudent);

    // Assert
    assertEquals(existingStudent.getStudentId(), result.getStudentId());
    assertEquals(updatedStudent.getName(), result.getName());
    assertEquals(updatedStudent.getAge(), result.getAge());
    assertEquals(updatedStudent.getEmail(), result.getEmail());
  }
}