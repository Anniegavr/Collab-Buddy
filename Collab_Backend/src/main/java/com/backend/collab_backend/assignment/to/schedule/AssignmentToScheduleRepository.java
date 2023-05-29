package com.backend.collab_backend.assignment.to.schedule;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssignmentToScheduleRepository extends JpaRepository<AssignmentToSchedule, Long> {
  Optional<AssignmentToSchedule> findAssignmentToScheduleById(Long id);
  List<AssignmentToSchedule> findAllByAssignmentId(Long assgnId);
  List<AssignmentToSchedule> findAllByGroupId(Long groupId);
}
