package com.collab.buddy.CollabBuddy.assignment;

import java.util.List;

public interface AssignmentService {
    List<Assignment> findAllAssignments();

    Assignment findAssignmentById(Long id);
    Assignment createAssignment(Assignment assignment);
    void deleteAssignment(Long id);
    Assignment updateAssignment(Long id, Assignment assignment);
}
