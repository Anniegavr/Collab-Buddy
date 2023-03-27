package com.collab.buddy.assignment;

import com.collab.buddy.teacher.TeacherDTO;

import java.util.List;

public interface AssignmentService {
    List<AssignmentDTO> findAllAssignments();

    AssignmentDTO findAssignmentById(Long id);
    AssignmentDTO createAssignment(AssignmentDTO assignment);
    void deleteAssignmentDTO(Long id);
    AssignmentDTO updateAssignment(Long id, AssignmentDTO assignment);

    AssignmentDTO findAssignmentById(Long id, TeacherDTO teacher);

    AssignmentDTO updateAssignment(Long id, AssignmentDTO assignment, TeacherDTO teacher);

    void updateAssignment(Long id, Assignment assignment, TeacherDTO teacher);

    void deleteAssignment(Long id);
}
