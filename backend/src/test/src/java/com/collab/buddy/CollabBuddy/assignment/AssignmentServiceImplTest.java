package com.collab.buddy.CollabBuddy.assignment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AssignmentServiceImplTest {

  @Mock
  private AssignmentRepository assignmentRepository;

  @InjectMocks
  private AssignmentServiceImpl assignmentService;

  private Assignment assignment1;
  private Assignment assignment2;
  private List<Assignment> assignments;

  @BeforeEach
  void setUp() {
    // create test assignments
    Teacher teacher1 = new Teacher(1L, "John Doe", 35, "john.doe@test.com", "Math", ERole.TEACHER);
    Teacher teacher2 = new Teacher(2L, "Jane Smith", 42, "jane.smith@test.com", "English", ERole.TEACHER);

    assignment1 = new Assignment(1L, "Assignment 1", "Description 1", "Math", "Work on chapter 3", LocalDate.now(), teacher1);
    assignment2 = new Assignment(2L, "Assignment 2", "Description 2", "English", "Write a book review", LocalDate.now(), teacher2);

    assignments = new ArrayList<>();
    assignments.add(assignment1);
    assignments.add(assignment2);
  }

  @Test
  void testFindAllAssignments() {
    // arrange
    when(assignmentRepository.findAll()).thenReturn(assignments);

    // act
    List<Assignment> result = assignmentService.findAllAssignments();

    // assert
    assertEquals(assignments, result);
    verify(assignmentRepository).findAll();
  }

  @Test
  void testFindAssignmentById() {
    // arrange
    Long assignmentId = 1L;
    when(assignmentRepository.findById(assignmentId)).thenReturn(Optional.of(assignment1));

    // act
    Assignment result = assignmentService.findAssignmentById(assignmentId);

    // assert
    assertEquals(assignment1, result);
    verify(assignmentRepository).findById(assignmentId);
  }

  @Test
  void testCreateAssignment() {
    // arrange
    when(assignmentRepository.save(assignment1)).thenReturn(assignment1);

    // act
    Assignment result = assignmentService.createAssignment(assignment1);

    // assert
    assertEquals(assignment1, result);
    verify(assignmentRepository).save(assignment1);
  }

  @Test
  void testUpdateAssignment() {
    // arrange
    Long assignmentId = 1L;
    String updatedName = "Updated Assignment";
    Assignment updatedAssignment = new Assignment(assignmentId, updatedName, assignment1.getDescription(), assignment1.getCourse(), assignment1.getDetails(), assignment1.getDueDate(), assignment1.getTeacher());

    when(assignmentRepository.findById(assignmentId)).thenReturn(Optional.of(assignment1));
    when(assignmentRepository.save(updatedAssignment)).thenReturn(updatedAssignment);

    // act
    Assignment result = assignmentService.updateAssignment(assignmentId, updatedAssignment);

    // assert
    assertEquals(updatedAssignment, result);
    verify(assignmentRepository).findById(assignmentId);
    verify(assignmentRepository).save(updatedAssignment);
  }

  @Test
  void testDeleteAssignment() {
    // arrange
    Long assignmentId = 1L;
    when(assignmentRepository.findById(assignmentId)).thenReturn(Optional.of(assignment1));

    // act
    assignmentService.deleteAssignment(assignmentId);

    // assert
    verify(assignmentRepository).deleteById(assignmentId);
  }

  @Test
  void testFindAssignmentsByCourse() {
    // arrange
    String course = "Math";
    List<Assignment> mathAssignments = new ArrayList<>();
    mathAssignments.add(assignment1);

    when(assignmentRepository.findByCourse(course)).thenReturn(mathAssignments);

    // act
    List<Assignment> result = assignmentService.findAssignmentsByCourse(course);

    // assert
    assertEquals(mathAssignments, result);
    verify(assignmentRepository).findByCourse(course);
  }

  @Test
  void testFindAssignmentsByDueDate() {
    // arrange
    LocalDate dueDate = LocalDate.now();
    List<Assignment> dueTodayAssignments = new ArrayList<>();
    dueTodayAssignments.add(assignment1);
    dueTodayAssignments.add(assignment2);

    when(assignmentRepository.findByDueDate(dueDate)).thenReturn(dueTodayAssignments);

    // act
    List<Assignment> result = assignmentService.findAssignmentsByDueDate(dueDate);

    // assert
    assertEquals(dueTodayAssignments, result);
    verify(assignmentRepository).findByDueDate(dueDate);
  }

  @Test
  void testFindAssignmentsByTeacher() {
    // arrange
    Long teacherId = 1L;
    List<Assignment> teacherAssignments = new ArrayList<>();
    teacherAssignments.add(assignment1);

    when(assignmentRepository.findByTeacher_Id(teacherId)).thenReturn(teacherAssignments);

    // act
    List<Assignment> result = assignmentService.findAssignmentsByTeacher(teacherId);

    // assert
    assertEquals(teacherAssignments, result);
    verify(assignmentRepository).findByTeacher_Id(teacherId);
  }

  @Test
  void testFindAssignmentsByNonexistentTeacher() {
    // arrange
    Long teacherId = 10L;

    when(assignmentRepository.findByTeacher_Id(teacherId)).thenReturn(new ArrayList<>());

    // act and assert
    assertThrows(TeacherNotFoundException.class, () -> assignmentService.findAssignmentsByTeacher(teacherId));
  }
}
