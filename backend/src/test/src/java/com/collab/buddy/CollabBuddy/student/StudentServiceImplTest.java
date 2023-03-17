package com.collab.buddy.CollabBuddy.student;
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
    Student student1 = new Student(1L, "John", 20, "john@gmail.com");
    Student student2 = new Student(2L, "Jane", 22, "jane@gmail.com");
    students.add(student1);
    students.add(student2);

    when(studentRepository.findAll()).thenReturn(students);

    // Act
    List<Student> result = studentService.getAllStudents();

    // Assert
    Assertions.assertNotNull(result);
    Assertions.assertEquals(students.size(), result.size());
    Assertions.assertEquals(students.get(0), result.get(0));
    Assertions.assertEquals(students.get(1), result.get(1));
    verify(studentRepository, times(1)).findAll();
  }

  @Test
  @DisplayName("Given a student ID, when getStudentById is called, then the corresponding student is returned")
  public void testGetStudentById() {
    // Arrange
    Student student = new Student(1L, "John", 20, "john@gmail.com");
    Long studentId = student.getStudentId();

    when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

    // Act
    Student result = studentService.getStudentById(studentId);

    // Assert
    Assertions.assertNotNull(result);
    Assertions.assertEquals(student, result);
    verify(studentRepository, times(1)).findById(studentId);
  }

  @Test
  @DisplayName("Given a student, when createStudent is called, then the student is created")
  public void testCreateStudent() {
    // Arrange
    Student student = new Student(null, "John", 20, "john@gmail.com");

    when(studentRepository.save(student)).thenReturn(student);

    // Act
    Student result = studentService.createStudent(student);

    // Assert
    Assertions.assertNotNull(result);
    Assertions.assertEquals(student, result);
    verify(studentRepository, times(1)).save(student);
  }

  @Test
  @DisplayName("Given a student ID, when deleteStudent is called, then the corresponding student is deleted")
  public void testDeleteStudent() {
    // Arrange
    Long studentId = 1L;

    // Act
    studentService.deleteStudent(studentId);

    // Assert
    verify(studentRepository, times(1)).deleteById(studentId);
  }

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