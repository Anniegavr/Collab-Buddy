package com.backend.collab_backend.assignment;

import com.backend.collab_backend.teacher.TeacherDTO;

import java.util.List;

public interface AssignmentService {
  List<AssignmentDTO> findAllAssignments(List<String> groups);

  AssignmentDTO findAssignmentById(Long id);
  AssignmentDTO createAssignment(AssignmentDTO assignment);
  AssignmentDTO updateAssignment(Long id, AssignmentDTO assignment);

  AssignmentDTO findAssignmentById(Long id, TeacherDTO teacher);

  void updateAssignment(Long id, Assignment assignment, TeacherDTO teacher);

  void deleteAssignment(Long id);
}

