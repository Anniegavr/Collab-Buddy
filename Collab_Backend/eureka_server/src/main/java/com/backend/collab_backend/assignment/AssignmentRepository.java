package com.backend.collab_backend.assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
  Optional<Assignment> findAssignmentByAssignmentId(Long id);
  Optional<Assignment> findAssignmentByTeacherName(String name);
  Optional<Assignment> findAssignmentByTeacherNameContainingIgnoreCase(String teacherName);
  Optional<Assignment> findAssignmentByTitleContainingIgnoreCase(String containing);
  List<Assignment> findAllByGroupId(String group);
}
