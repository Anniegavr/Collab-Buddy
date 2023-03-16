package com.collab.buddy.CollabBuddy.assignment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
public class AssignmentServiceTest {

  @Autowired
  private AssignmentService assignmentService;

  @Test
  public void testUpdateAssignment() {
    // Create a new assignment
    Assignment assignment = new Assignment();
    assignment.setName("Test Assignment");
    assignment.setDescription("This is a test assignment.");
    assignment.setDueDate(LocalDate.now().plusDays(7));

    // Save the assignment
    assignment = assignmentService.createAssignment(assignment);

    // Update the assignment
    assignment.setName("Updated Test Assignment");
    assignment.setDescription("This is an updated test assignment.");
    assignment.setDueDate(LocalDate.now().plusDays(14));

    Assignment updatedAssignment = assignmentService.updateAssignment(assignment.getId(), assignment);

    assertThat(updatedAssignment).isNotNull();
    assertThat(updatedAssignment.getName()).isEqualTo("Updated Test Assignment");
    assertThat(updatedAssignment.getDescription()).isEqualTo("This is an updated test assignment.");
    assertThat(updatedAssignment.getDueDate()).isEqualTo(LocalDate.now().plusDays(14));
  }

  @Test
  public void testCreateAssignment() {
    // Create a new assignment
    Assignment assignment = new Assignment();
    assignment.setName("Test Assignment");
    assignment.setDescription("This is a test assignment.");
    assignment.setDueDate(LocalDate.now().plusDays(7));

    // Save the assignment
    Assignment savedAssignment = assignmentService.createAssignment(assignment);

    // Verify that the assignment was saved successfully
    assertThat(savedAssignment).isNotNull();
    assertThat(savedAssignment.getId()).isNotNull();
    assertThat(savedAssignment.getName()).isEqualTo("Test Assignment");
    assertThat(savedAssignment.getDescription()).isEqualTo("This is a test assignment.");
    assertThat(savedAssignment.getDueDate()).isEqualTo(LocalDate.now().plusDays(7));

    // Verify that the assignment can be retrieved using the findAssignmentById() method
    Assignment retrievedAssignment = assignmentService.findAssignmentById(savedAssignment.getId());
    assertThat(retrievedAssignment).isNotNull();
    assertThat(retrievedAssignment.getId()).isEqualTo(savedAssignment.getId());
    assertThat(retrievedAssignment.getName()).isEqualTo("Test Assignment");
    assertThat(retrievedAssignment.getDescription()).isEqualTo("This is a test assignment.");
    assertThat(retrievedAssignment.getDueDate()).isEqualTo(LocalDate.now().plusDays(7));
  }
  @Test
  public void testUpdateAssignmentWithInvalidId() {
    Assignment assignment = new Assignment();
    assignment.setId(100L);
    assignment.setName("Test Assignment");
    assignment.setDescription("This is a test assignment.");
    assignment.setDueDate(LocalDate.now().plusDays(7));
    assignment.setTeacher("Daniel Defoe");

    assertThrows(RuntimeException.class, () -> assignmentService.updateAssignment(assignment.getId(), assignment));
  }
}
