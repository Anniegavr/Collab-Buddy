package com.collab.buddy.student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

  private StudentServiceImpl studentService;

  @Mock
  private StudentRepository studentRepository;

  @BeforeEach
  public void setUp() {
    studentService = new StudentServiceImpl(studentRepository);
  }

  @Test
  @DisplayName("Given a list of students, when getAllStudents is called, then the list of students is returned")
  public void testGetAllStudents() {
    // Arrange
    List<Student> students = new ArrayList<>();
    Student student1 = new Student();
    student1.setFirstName("John");
    student1.setLastName("Doe");
    student1.setYear(2);
    student1.setSpecialty("IT");
    student1.setAge(20);
    student1.setEmail("john@gmail.com");

    Student student2 = new Student();
    student1.setFirstName("Jane");
    student1.setLastName("Doe");
    student1.setYear(4);
    student1.setSpecialty("IT");
    student1.setAge(22);
    student1.setEmail("jane@gmail.com");

    students.add(student1);
    students.add(student2);

    when(studentRepository.findAll()).thenReturn(students);

    // Act
    List<StudentDTO> result = studentService.getAllStudents();

    // Assert
    Assertions.assertNotNull(result);
    assertEquals(students.size(), result.size());
    assertEquals(students.get(0).getEmail(), result.get(0).email);
    assertEquals(students.get(1).getEmail(), result.get(1).email);
    verify(studentRepository, times(1)).findAll();
  }

  @Test
  @DisplayName("Given a student ID, when getStudentById is called, then the corresponding student is returned")
  public void testGetStudentById() {
    // Arrange
    Student student = new Student();
    student.setFirstName("John");
    student.setLastName("Doe");
    student.setYear(2);
    student.setSpecialty("IT");
    student.setAge(20);
    student.setEmail("john@gmail.com");
    Long studentId = student.getId();

    when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

    // Act
    StudentDTO result = studentService.getStudentById(studentId);

    // Assert
    Assertions.assertNotNull(result);
    assertEquals(student.getEmail(), result.email);
    verify(studentRepository, times(1)).findById(studentId);
  }

  @Test
  @DisplayName("Given a student, when createStudent is called, then the student is created")
  public void testCreateStudent() {
    // Arrange
    Student student = new Student();//(null, "John", 20, "john@gmail.com");
    student.setFirstName("John");
    student.setLastName("Doe");
    student.setYear(2);
    student.setSpecialty("IT");
    student.setAge(20);
    student.setEmail("john@gmail.com");

    when(studentRepository.save(student)).thenReturn(student);

    // Act
    StudentDTO result = studentService.createStudent(student);

    // Assert
    Assertions.assertNotNull(result);
    assertEquals(student.getEmail(), result.email);
    verify(studentRepository, times(1)).save(student);
  }

  @Test
  @DisplayName("Given a student ID, when deleteStudent is called, then the corresponding student is deleted")
  void testDeleteStudent() {
    // Arrange
    Long studentId = 1L;

    // Act
    studentService.deleteStudent(studentId);

    // Assert
    verify(studentRepository, times(1)).deleteById(studentId);
  }

  @Test
  void updateStudent_ShouldReturnUpdatedStudent() throws Exception {
    // Arrange
    Long id = 1L;
    Student existingStudent = new Student();
    existingStudent.setId(id);
    existingStudent.setFirstName("John");
    existingStudent.setLastName("Doe");
    existingStudent.setAge(25);
    existingStudent.setEmail("john.doe@example.com");

    StudentDTO updatedStudent = new StudentDTO(2, "IT", "jane.doe@example.com");

    when(studentRepository.findStudentByStudentId(id)).thenReturn(Optional.of(existingStudent));
    when(studentRepository.save(existingStudent)).thenReturn(existingStudent);

    // Act
    StudentDTO result = studentService.updateStudent(id, updatedStudent);

    // Assert
    assertEquals(existingStudent.getYear(), result.year);
    assertEquals(updatedStudent.email, result.email);
  }
}